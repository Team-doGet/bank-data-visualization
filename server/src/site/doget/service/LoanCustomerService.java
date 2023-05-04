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

    // 고객 종류별 대출 고객 수 조회
    public CustomerCountListByTypeResDto findLoanByCustomerType(BankReqDto bankReqDto) {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            LoanCustomerMapper loanCustomerMapper = sqlSession.getMapper(LoanCustomerMapper.class);
            List<CustomerCountByTypeRawDto> customerCountByTypeRawDtoList = loanCustomerMapper.findLoanByCustomerType(bankReqDto);

            // CustTypeCompListResDto
            List<String> dates = new ArrayList<>();
            List<List<String>> data = new ArrayList<>();
            data.add(new ArrayList<>());
            data.add(new ArrayList<>());

            // datasets 추가
            customerCountByTypeRawDtoList.forEach(customerCountByTypeRawDto -> {
                if (!dates.contains(customerCountByTypeRawDto.getNewDt())) {
                    dates.add(customerCountByTypeRawDto.getNewDt());
                }
                int dataIndex = "개인".equals(customerCountByTypeRawDto.getCustDscdNm()) ? 0 : 1;
                data.get(dataIndex).add(customerCountByTypeRawDto.getCount());
            });

            List<CustomerCountByTypeResDto> datasets = new ArrayList<>();
            datasets.add(new CustomerCountByTypeResDto("개인", data.get(0)));
            datasets.add(new CustomerCountByTypeResDto("법인", data.get(1)));
            return new CustomerCountListByTypeResDto(dates, datasets);
        }

    }

    // 금액별 대출 고객 수 조회
    public CustomerCountListByAmountResDto findLoanByAmount(BankReqDto bankReqDto) {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            LoanCustomerMapper loanCustomerMapper = sqlSession.getMapper(LoanCustomerMapper.class);
            List<CustomerCountByAmountRawDto> customerCountByAmountRawDtoList = loanCustomerMapper.findLoanByAmount(bankReqDto);

            // CustomerCountListByAmountResDto
            List<String> labels = new ArrayList<>();
            List<List<String>> data = new ArrayList<>();
            data.add(new ArrayList<>());
            data.add(new ArrayList<>());

            // datasets 추가
            customerCountByAmountRawDtoList.forEach(customerCountByAmountRawDto -> {
                if (!labels.contains(customerCountByAmountRawDto.getRange())) {
                    labels.add(customerCountByAmountRawDto.getRange());
                }
                int dataIndex = "개인".equals(customerCountByAmountRawDto.getCustDscdNm()) ? 0 : 1;
                data.get(dataIndex).add(customerCountByAmountRawDto.getCount());
            });

            List<CustomerCountByAmountResDto> datasets = new ArrayList<>();
            datasets.add(new CustomerCountByAmountResDto("개인", data.get(0)));
            datasets.add(new CustomerCountByAmountResDto("법인", data.get(1)));
            return new CustomerCountListByAmountResDto(labels, datasets);
        }
    }
}
