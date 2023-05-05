package site.doget.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import site.doget.common.CodeMapper;
import site.doget.dto.FinancialListResDto;
import site.doget.dto.FinancialReqDto;
import site.doget.dto.FinancialResDto;
import site.doget.dto.raw.FnnrRawDto;
import site.doget.mybatis.mapper.FinancialMapper;
import site.doget.mybatis.SqlSessionFactoryProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinancialService {
    private static final FinancialService instance = new FinancialService();
    public static FinancialService getInstance() {return instance;}
    private FinancialService() {
    }

    private final SqlSessionFactory sqlSessionFactory = SqlSessionFactoryProvider.getInstance();

    public FinancialListResDto findByTermAndBankCode(FinancialReqDto financialReqDto) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            FinancialMapper financialMapper = sqlSession.getMapper(FinancialMapper.class);
            List<FnnrRawDto> fnnrRawDtoList = financialMapper.findByTermAndBankCode(financialReqDto);

            // FinancialListResDto
            List<String> labels = new ArrayList<>();
            List<FinancialResDto> datasets = new ArrayList<>();

            // FinancialResDto
            String[] codes = CodeMapper.financialMap.keySet().toArray(new String[0]);
            Arrays.sort(codes);

            for (String code : codes) {
                datasets.add(new FinancialResDto(code, CodeMapper.financialMap.get(code), new ArrayList<>()));
            }

            for (FnnrRawDto fnnrRawDto : fnnrRawDtoList) {
                labels.add(fnnrRawDto.getBaseYm());
                for (int i = 0; i < codes.length; i++) {
                    datasets.get(i).getData().add(fnnrRawDto.getValueByCode(codes[i]));
                }
            }

            return new FinancialListResDto(labels, datasets);
        }
    }
}