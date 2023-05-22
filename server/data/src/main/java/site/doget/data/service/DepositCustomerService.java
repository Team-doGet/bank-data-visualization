package site.doget.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.doget.data.dto.*;
import site.doget.data.dto.raw.CustomerCountByAmountRawDto;
import site.doget.data.dto.raw.CustomerCountByRegionRawDto;
import site.doget.data.dto.raw.CustomerCountByTypeRawDto;
import site.doget.data.mapper.DepositCustomerMapper;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DepositCustomerService {

    private final DepositCustomerMapper depositCustomerMapper;

    @SuppressWarnings("unchecked")

    private <T> List<T> executeQuery(BankReqDto bankReqDto, Class<T> rawDtoClass) {

        if (rawDtoClass == CustomerCountByTypeRawDto.class) {
            return (List<T>) depositCustomerMapper.findDepositByCustomerType(bankReqDto);
        } else if (rawDtoClass == CustomerCountByAmountRawDto.class) {
            return (List<T>) depositCustomerMapper.findDepositByAmount(bankReqDto);
        } else if (rawDtoClass == CustomerCountByRegionRawDto.class) {
            return (List<T>) depositCustomerMapper.findDepositByRegion(bankReqDto);
        }

        throw new IllegalArgumentException("지원하지 않는 rawDtoClass 입니다.: " + rawDtoClass);
    }

    // 고객 종류별 예금 고객 수 조회
    public CustomerCountListByTypeResDto findDepositByCustomerType(BankReqDto bankReqDto) {

        List<CustomerCountByTypeRawDto> customerCountByTypeRawDtoList = executeQuery(bankReqDto, CustomerCountByTypeRawDto.class);

        // CustTypeCompListResDto
        List<String> dates = new ArrayList<>();
        List<List<Integer>> data = new ArrayList<>();
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

    // 금액별 대출 고객 수 조회
    public CustomerCountListByAmountResDto findDepositByAmount(BankReqDto bankReqDto) {

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

    public CustomerCountByRegionDto findDepositByRegion(BankReqDto bankReqDto) {

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
