package site.doget.controller;

import site.doget.common.ApiResponse;
import site.doget.common.ValidationResult;
import site.doget.dto.BankReqDto;
import site.doget.dto.CustomerCountByRegionDto;
import site.doget.dto.CustomerCountListByAmountResDto;
import site.doget.dto.CustomerCountListByTypeResDto;
import site.doget.service.DepositCustomerService;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class DepositCustomerController implements Controller {

    DepositCustomerService depositCustomerService = DepositCustomerService.getInstance();

    @Override
    public ApiResponse<?> process(String requestURI, Map<String, String> paramMap) {

        if(requestURI.endsWith("/type")) {
            return findDepositByCustomerType(paramMap);
        }
        else if (requestURI.endsWith("/amount")) {
            return findDepositByAmount(paramMap);
        }
        else if (requestURI.endsWith("/region")) {
            return findDepositByRegion(paramMap);
        }
        else {
            return new ApiResponse<>(HttpServletResponse.SC_NOT_FOUND, "요청한 URI가 존재하지 않습니다.");
        }
    }

    // 고객 종류별 예금 고객 수 조회
    public ApiResponse<?> findDepositByCustomerType(Map<String, String> paramMap) {

        BankReqDto bankReqDto = createBankReqDto(paramMap);

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        CustomerCountListByTypeResDto depositByCustomerType = depositCustomerService.findDepositByCustomerType(bankReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, depositByCustomerType);
    }

    // 금액별 예금 고객 수 조회
    public ApiResponse<?> findDepositByAmount(Map<String, String> paramMap) {

        BankReqDto bankReqDto = createBankReqDto(paramMap);

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        CustomerCountListByAmountResDto depositByAmount = depositCustomerService.findDepositByAmount(bankReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, depositByAmount);
    }

    // 지역별 예금 고객 수 조회
    public ApiResponse<?> findDepositByRegion(Map<String, String> paramMap) {

        BankReqDto bankReqDto = createBankReqDto(paramMap);

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        CustomerCountByRegionDto depositByRegion = depositCustomerService.findDepositByRegion(bankReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, depositByRegion);
    }

    private BankReqDto createBankReqDto(Map<String, String> paramMap) {
        return new BankReqDto(paramMap.get("bankCode"), paramMap.get("term"),
                paramMap.get("stDate"), paramMap.get("endDate"));
    }
}
