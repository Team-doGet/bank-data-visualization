package site.doget.controller;

import site.doget.common.ApiResponse;
import site.doget.common.ValidationResult;
import site.doget.dto.BankReqDto;
import site.doget.dto.LoanGuaranteeListResDto;
import site.doget.dto.LoanPeriodListResDto;
import site.doget.dto.LoanStatsListResDto;
import site.doget.service.LoanInfoService;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LoanInfoController implements Controller{
    LoanInfoService loanInfoService = LoanInfoService.getInstance();

    @Override
    public ApiResponse<?> process(String requestURI, Map<String, String> paramMap) {
        if (requestURI.endsWith("/guarantee")) {
            return findLoanGuaranteeByTermAndBankCode(paramMap);
        } else if (requestURI.endsWith("/period")) {
            return findLoanPeriodByTermAndBankCode(paramMap);
        } else if (requestURI.endsWith("/stats")) {
            return findLoanStatsByTermAndBankCode(paramMap);
        } else {
            return new ApiResponse<>(HttpServletResponse.SC_NOT_FOUND, "요청한 URI가 존재하지 않습니다.");
        }
    }

    public ApiResponse<?> findLoanGuaranteeByTermAndBankCode(Map<String, String> paramMap) {
        BankReqDto bankReqDto = new BankReqDto(paramMap.get("bankCode"), paramMap.get("term"),
                paramMap.get("stDate"), paramMap.get("endDate"));

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        LoanGuaranteeListResDto loanGuaranteeListResDto = loanInfoService.findLoanGuaranteeByTermAndBankCode(bankReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, loanGuaranteeListResDto);
    }

    public ApiResponse<?> findLoanPeriodByTermAndBankCode(Map<String, String> paramMap) {
        BankReqDto bankReqDto = new BankReqDto(paramMap.get("bankCode"), paramMap.get("term"),
                paramMap.get("stDate"), paramMap.get("endDate"));

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        LoanPeriodListResDto loanPeriodListResDto = loanInfoService.findLoanPeriodByTermAndBankCode(bankReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, loanPeriodListResDto);
    }

    public ApiResponse<?> findLoanStatsByTermAndBankCode(Map<String, String> paramMap) {
        BankReqDto bankReqDto = new BankReqDto(paramMap.get("bankCode"), paramMap.get("term"),
                paramMap.get("stDate"), paramMap.get("endDate"));

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        LoanStatsListResDto loanStatsListResDto = loanInfoService.findLoanStatsByTermAndBankCode(bankReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, loanStatsListResDto);
    }
}
