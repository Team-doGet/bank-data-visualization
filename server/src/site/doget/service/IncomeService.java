package site.doget.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import site.doget.common.CodeMapper;
import site.doget.dto.IncomeDto;
import site.doget.dto.IncomeListDto;
import site.doget.dto.PlosdocDto;
import site.doget.mybatis.mapper.IncomeMapper;
import site.doget.mybatis.SqlSessionFactoryProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class IncomeService {

    private static final IncomeService instance = new IncomeService();

    public static IncomeService getInstance() {
        return instance;
    }

    private IncomeService() {
    }

    private final SqlSessionFactory sqlSessionFactory = SqlSessionFactoryProvider.getInstance();

    public IncomeListDto findByTermAndBankCode(Map<String, String> paramMap) {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IncomeMapper incomeMapper = sqlSession.getMapper(IncomeMapper.class);
            List<PlosdocDto> plosdocDtoList = incomeMapper.findByTermAndBankCode(paramMap);


            // IncomeListDto
            List<String> date = new ArrayList<>();
            List<IncomeDto> datasets = new ArrayList<>();

            // IncomeDto List 객체 생성
            String[] codes = CodeMapper.incomeMap.keySet().toArray(new String[0]);
            Arrays.sort(codes);

            for (String code : codes) {
                datasets.add(new IncomeDto(code, CodeMapper.incomeMap.get(code), new ArrayList<>()));
            }

            // datasets 추가
            for (PlosdocDto plosdocDto : plosdocDtoList) {
                date.add(plosdocDto.getBaseYm());
                for (int i = 0; i < codes.length; i++) {
                    datasets.get(i).getData().add(plosdocDto.getValueByCode(codes[i]));
                }
            }

            return new IncomeListDto(date, datasets);
        }
    }

}
