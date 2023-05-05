package site.doget.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import site.doget.dto.BankReqDto;
import site.doget.dto.DepositTypeListResDto;
import site.doget.dto.DepositTypeResDto;
import site.doget.dto.LoanGuaranteeResDto;
import site.doget.dto.raw.DepositInfoRawDto;
import site.doget.dto.raw.LoanInfoRawDto;
import site.doget.mybatis.SqlSessionFactoryProvider;
import site.doget.mybatis.mapper.DepositInfoMapper;
import site.doget.mybatis.mapper.LoanInfoMapper;

import java.util.*;

public class DepositInfoService {
    private static final DepositInfoService instance = new DepositInfoService();
    public static DepositInfoService getInstance() {return instance;}
    private DepositInfoService() {

    }

    private final SqlSessionFactory sqlSessionFactory = SqlSessionFactoryProvider.getInstance();

    public DepositTypeListResDto findDepositTypeByTermAndBankCode(BankReqDto bankReqDto) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            DepositInfoMapper depositInfoMapper = sqlSession.getMapper(DepositInfoMapper.class);
            List<DepositInfoRawDto> depositInfoRawDtoList = depositInfoMapper.findDepositTypeByTermAndBankCode(bankReqDto);

            List<String> labels = new ArrayList<>();
            List<DepositTypeResDto> datasets = new ArrayList<>();


            Set<String> typeSet = new HashSet<String>();
            for (DepositInfoRawDto depositInfoRawDto : depositInfoRawDtoList) {
                typeSet.add(depositInfoRawDto.getAccSbjcNm());
            }
            String[] depositTypeList = typeSet.toArray(new String[typeSet.size()]);

            Set<String> baseYmSet = new HashSet<String>();
            for (DepositInfoRawDto depositInfoRawDto : depositInfoRawDtoList) {
                baseYmSet.add(depositInfoRawDto.getBaseYm());
            }
            String[] labelList = baseYmSet.toArray(new String[baseYmSet.size()]);
            Arrays.sort(labelList);
            labels = List.of(labelList);

            for (String depositType : depositTypeList) {
                datasets.add(new DepositTypeResDto(depositType, new ArrayList<>()));
            }

            List<Integer> cntList = new ArrayList<Integer >();
            for (DepositInfoRawDto depositInfoRawDto : depositInfoRawDtoList) {
                cntList.add(depositInfoRawDto.getCnt());
            }

            int k = 0;
            for (int i = 0; i < depositTypeList.length; i++) {
                for (int j = 0; j < depositInfoRawDtoList.size() / depositTypeList.length; j++) {
                    if (k >= cntList.size()) break;
                    datasets.get(i).getData().add(cntList.get(k++));
                }
            }

            return new DepositTypeListResDto(labels, datasets);
        }
    }
}
