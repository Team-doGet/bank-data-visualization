package site.doget.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import site.doget.common.CodeMapper;
import site.doget.dto.IncomeResDto;
import site.doget.dto.IncomeListResDto;
import site.doget.dto.IncomeReqDto;
import site.doget.dto.PlosdocRawDto;
import site.doget.mybatis.mapper.IncomeMapper;
import site.doget.mybatis.SqlSessionFactoryProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncomeService {

    private static final IncomeService instance = new IncomeService();

    public static IncomeService getInstance() {
        return instance;
    }

    private IncomeService() {
    }

    private final SqlSessionFactory sqlSessionFactory = SqlSessionFactoryProvider.getInstance();

    public IncomeListResDto findByTermAndBankCode(IncomeReqDto incomeReqDto) {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IncomeMapper incomeMapper = sqlSession.getMapper(IncomeMapper.class);
            List<PlosdocRawDto> plosdocRawDtoList = incomeMapper.findByTermAndBankCode(incomeReqDto);


            // IncomeListDto
            List<String> date = new ArrayList<>();
            List<IncomeResDto> datasets = new ArrayList<>();

            // IncomeDto List 객체 생성
            String[] codes = CodeMapper.incomeMap.keySet().toArray(new String[0]);
            Arrays.sort(codes);

            for (String code : codes) {
                datasets.add(new IncomeResDto(code, CodeMapper.incomeMap.get(code), new ArrayList<>()));
            }

            // datasets 추가
            for (PlosdocRawDto plosdocRawDto : plosdocRawDtoList) {
                date.add(plosdocRawDto.getBaseYm());
                for (int i = 0; i < codes.length; i++) {
                    datasets.get(i).getData().add(plosdocRawDto.getValueByCode(codes[i]));
                }
            }

            return new IncomeListResDto(date, datasets);
        }
    }

}
