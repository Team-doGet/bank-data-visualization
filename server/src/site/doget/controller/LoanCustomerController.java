package site.doget.controller;

import site.doget.common.ApiResponse;
import site.doget.common.ValidationResult;
import site.doget.dto.BankReqDto;
import site.doget.dto.CustTypeCompListResDto;
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
        else {
            return new ApiResponse<>(HttpServletResponse.SC_NOT_FOUND, "요청한 URI가 존재하지 않습니다.");
        }
    }

    public ApiResponse<?> findLoanByCustomerType(Map<String, String> paramMap) {

        BankReqDto bankReqDto = new BankReqDto(paramMap.get("bankCode"), paramMap.get("term"),
                paramMap.get("stDate"), paramMap.get("endDate"));

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        CustTypeCompListResDto loanByCustomerType = loanCustomerService.findLoanByCustomerType(bankReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, loanByCustomerType);
    }
}
