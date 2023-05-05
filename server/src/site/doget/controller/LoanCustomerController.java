package site.doget.controller;

import site.doget.common.ApiResponse;
import site.doget.common.ValidationResult;
import site.doget.dto.BankReqDto;
import site.doget.dto.CustomerCountByRegionDto;
import site.doget.dto.CustomerCountListByAmountResDto;
import site.doget.dto.CustomerCountListByTypeResDto;
import site.doget.service.LoanCustomerService;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LoanCustomerController implements Controller {

    LoanCustomerService loanCustomerService = LoanCustomerService.getInstance();

    @Override
    public ApiResponse<?> process(String requestURI, Map<String, String> paramMap) {

        if(requestURI.endsWith("/type")) {
            return findLoanByCustomerType(paramMap);
        }
        else if (requestURI.endsWith("/amount")) {
            return findLoanByAmount(paramMap);
        }
        else if (requestURI.endsWith("/region")) {
            return findLoanByRegion(paramMap);
        }
        else {
            return new ApiResponse<>(HttpServletResponse.SC_NOT_FOUND, "요청한 URI가 존재하지 않습니다.");
        }
    }

    // 고객 종류별 대출 고객 수 조회
    public ApiResponse<?> findLoanByCustomerType(Map<String, String> paramMap) {

        BankReqDto bankReqDto = createBankReqDto(paramMap);

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        CustomerCountListByTypeResDto loanByCustomerType = loanCustomerService.findLoanByCustomerType(bankReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, loanByCustomerType);
    }

    // 금액별 대출 고객 수 조회
    public ApiResponse<?> findLoanByAmount(Map<String, String> paramMap) {

        BankReqDto bankReqDto = createBankReqDto(paramMap);

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        CustomerCountListByAmountResDto loanByAmount = loanCustomerService.findLoanByAmount(bankReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, loanByAmount);
    }

    // 지역별 대출 고객 수 조회
    public ApiResponse<?> findLoanByRegion(Map<String, String> paramMap) {

        BankReqDto bankReqDto = createBankReqDto(paramMap);

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        CustomerCountByRegionDto loanByRegion = loanCustomerService.findLoanByRegion(bankReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, loanByRegion);
    }


    private BankReqDto createBankReqDto(Map<String, String> paramMap) {
        return new BankReqDto(paramMap.get("bankCode"), paramMap.get("term"),
                paramMap.get("stDate"), paramMap.get("endDate"));
    }



}
