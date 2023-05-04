package site.doget.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import site.doget.dto.*;
import site.doget.mybatis.SqlSessionFactoryProvider;
import site.doget.mybatis.mapper.LoanCustomerMapper;

import java.util.ArrayList;
import java.util.List;

public class LoanCustomerService {

    private static final LoanCustomerService instance = new LoanCustomerService();

    public static LoanCustomerService getInstance() {
        return instance;
    }

    private LoanCustomerService() {
    }

    private final SqlSessionFactory sqlSessionFactory = SqlSessionFactoryProvider.getInstance();

    // 고객 종류별 비교 조회
    public CustTypeCompListResDto findLoanByCustomerType(BankReqDto bankReqDto) {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            LoanCustomerMapper loanCustomerMapper = sqlSession.getMapper(LoanCustomerMapper.class);
            List<CustTypeRawDto> custTypeRawDtoList = loanCustomerMapper.findLoanByCustomerType(bankReqDto);

            // CustTypeCompListResDto
            List<String> dates = new ArrayList<>();
            List<List<String>> data = new ArrayList<>();
            data.add(new ArrayList<>());
            data.add(new ArrayList<>());

            // datasets 추가
            custTypeRawDtoList.forEach(custTypeRawDto -> {
                if (!dates.contains(custTypeRawDto.getNewDt())) {
                    dates.add(custTypeRawDto.getNewDt());
                }
                int dataIndex = "개인".equals(custTypeRawDto.getCustDscdNm()) ? 0 : 1;
                data.get(dataIndex).add(custTypeRawDto.getCount());
            });

            List<CustTypeCompResDto> datasets = new ArrayList<>();
            datasets.add(new CustTypeCompResDto("개인", data.get(0)));
            datasets.add(new CustTypeCompResDto("법인", data.get(1)));
            return new CustTypeCompListResDto(dates, datasets);
        }

    }
}
