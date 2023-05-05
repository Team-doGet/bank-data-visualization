package site.doget.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import site.doget.dto.*;
import site.doget.dto.raw.LoanInfoRawDto;
import site.doget.mybatis.SqlSessionFactoryProvider;
import site.doget.mybatis.mapper.LoanInfoMapper;

import java.util.*;

public class LoanInfoService {
    private static final LoanInfoService instance = new LoanInfoService();
    public static LoanInfoService getInstance() {return instance;}
    private LoanInfoService() {

    }

    private final SqlSessionFactory sqlSessionFactory = SqlSessionFactoryProvider.getInstance();

    public LoanGuaranteeListResDto findLoanGuaranteeByTermAndBankCode(BankReqDto bankReqDto) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            LoanInfoMapper loanInfoMapper = sqlSession.getMapper(LoanInfoMapper.class);
            List<LoanInfoRawDto> loanInfoRawDtoList = loanInfoMapper.findLoanGuaranteeByTermAndBankCode(bankReqDto);

            List<String> labels = new ArrayList<>();
            List<LoanGuaranteeResDto> datasets = new ArrayList<>();

            Set<String> guranteeSet = new HashSet<String>();
            for (LoanInfoRawDto loanInfoRawDto : loanInfoRawDtoList) {
                guranteeSet.add(loanInfoRawDto.getCredMrtgNm());
            }
            String[] guaranteeTypeList = guranteeSet.toArray(new String[guranteeSet.size()]);

            Set<String> baseYmSet = new HashSet<String>();
            for (LoanInfoRawDto loanInfoRawDto : loanInfoRawDtoList) {
                baseYmSet.add(loanInfoRawDto.getBaseYm());
            }
            String[] labelList = baseYmSet.toArray(new String[baseYmSet.size()]);
            Arrays.sort(labelList);
            labels = List.of(labelList);

            for (String guaranteeType : guaranteeTypeList) {
                datasets.add(new LoanGuaranteeResDto(guaranteeType, new ArrayList<>()));
            }

            List<Integer> cntList = new ArrayList<Integer >();
            for (LoanInfoRawDto loanInfoRawDto : loanInfoRawDtoList) {
                cntList.add(loanInfoRawDto.getCnt());
            }

            int k = 0;
            for (int i = 0; i < guaranteeTypeList.length; i++) {
                for (int j = 0; j < loanInfoRawDtoList.size() / guaranteeTypeList.length; j++) {
                    if (k >= cntList.size()) break;
                    datasets.get(i).getData().add(cntList.get(k++));
                }
            }

            return new LoanGuaranteeListResDto(labels, datasets);
        }
    }
}
