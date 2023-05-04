package site.doget.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import site.doget.dto.*;
import site.doget.mybatis.SqlSessionFactoryProvider;
import site.doget.mybatis.mapper.DepositCustomerMapper;
import site.doget.mybatis.mapper.LoanCustomerMapper;

import java.util.ArrayList;
import java.util.List;

public class DepositCustomerService {

    private static final DepositCustomerService instance = new DepositCustomerService();

    public static DepositCustomerService getInstance() {
        return instance;
    }

    private DepositCustomerService() {
    }

    private final SqlSessionFactory sqlSessionFactory = SqlSessionFactoryProvider.getInstance();

    // 고객 종류별 비교 조회
    public CustomerCountListByTypeResDto findDepositByCustomerType(BankReqDto bankReqDto) {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            DepositCustomerMapper depositCustomerMapper = sqlSession.getMapper(DepositCustomerMapper.class);
            List<CustomerCountByTypeRawDto> customerCountByTypeRawDtoList = depositCustomerMapper.findDepositByCustomerType(bankReqDto);

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
}
