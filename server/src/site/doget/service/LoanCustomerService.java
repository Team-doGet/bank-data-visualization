package site.doget.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import site.doget.dto.*;
import site.doget.dto.raw.CustomerCountByAmountRawDto;
import site.doget.dto.raw.CustomerCountByRegionRawDto;
import site.doget.dto.raw.CustomerCountByTypeRawDto;
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

    @SuppressWarnings("unchecked")
    private <T> List<T> executeQuery(BankReqDto bankReqDto, Class<T> rawDtoClass) {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            LoanCustomerMapper loanCustomerMapper = sqlSession.getMapper(LoanCustomerMapper.class);

            if (rawDtoClass == CustomerCountByTypeRawDto.class) {
                return (List<T>) loanCustomerMapper.findLoanByCustomerType(bankReqDto);
            }
            else if (rawDtoClass == CustomerCountByAmountRawDto.class) {
                return (List<T>) loanCustomerMapper.findLoanByAmount(bankReqDto);
            }
            else if (rawDtoClass == CustomerCountByRegionRawDto.class) {
                return (List<T>) loanCustomerMapper.findLoanByRegion(bankReqDto);
            }

            throw new IllegalArgumentException("지원하지 않는 rawDtoClass 입니다.: " + rawDtoClass);
        }
    }

    // 고객 종류별 대출 고객 수 조회
    public CustomerCountListByTypeResDto findLoanByCustomerType(BankReqDto bankReqDto) {

        List<CustomerCountByTypeRawDto> customerCountByTypeRawDtoList = executeQuery(bankReqDto, CustomerCountByTypeRawDto.class);

        // CustomerCountListByTypeResDto
        List<String> labels = new ArrayList<>();
        List<List<Integer>> data = new ArrayList<>();
        data.add(new ArrayList<>());
        data.add(new ArrayList<>());

        // datasets 추가
        customerCountByTypeRawDtoList.forEach(customerCountByTypeRawDto -> {
            if (!labels.contains(customerCountByTypeRawDto.getNewDt())) {
                labels.add(customerCountByTypeRawDto.getNewDt());
            }
            int dataIndex = "개인".equals(customerCountByTypeRawDto.getCustDscdNm()) ? 0 : 1;
            data.get(dataIndex).add(customerCountByTypeRawDto.getCount());
        });

        List<CustomerCountByTypeResDto> datasets = new ArrayList<>();
        datasets.add(new CustomerCountByTypeResDto("개인", data.get(0)));
        datasets.add(new CustomerCountByTypeResDto("법인", data.get(1)));
        return new CustomerCountListByTypeResDto(labels, datasets);
    }

    // 금액별 대출 고객 수 조회
    public CustomerCountListByAmountResDto findLoanByAmount(BankReqDto bankReqDto) {

        List<CustomerCountByAmountRawDto> customerCountByAmountRawDtoList = executeQuery(bankReqDto, CustomerCountByAmountRawDto.class);

        // CustomerCountListByAmountResDto
        List<String> labels = new ArrayList<>();
        List<List<Integer>> data = new ArrayList<>();
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

    // 지역별 대출 고객 수 조회
    public CustomerCountByRegionDto findLoanByRegion(BankReqDto bankReqDto) {

        List<CustomerCountByRegionRawDto> customerCountByRegionRawDtoList = executeQuery(bankReqDto, CustomerCountByRegionRawDto.class);

        // CustomerCountByRegionDto
        List<String> labels = new ArrayList<>();
        List<Integer> datasets = new ArrayList<>();

        // datasets 추가
        customerCountByRegionRawDtoList.forEach(customerCountByRegionRawDto -> {
            labels.add(customerCountByRegionRawDto.getCustLctplcNm());
            datasets.add(customerCountByRegionRawDto.getCount());
        });

        return new CustomerCountByRegionDto(labels, datasets);
    }



}
