package site.doget.controller;

import site.doget.common.ApiResponse;
import site.doget.common.ValidationResult;
import site.doget.dto.BankReqDto;
import site.doget.dto.DepositPeriodListResDto;
import site.doget.dto.DepositTypeListResDto;
import site.doget.dto.LoanGuaranteeListResDto;
import site.doget.service.DepositInfoService;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class DepositInfoController implements Controller{
    DepositInfoService depositInfoService = DepositInfoService.getInstance();

    @Override
    public ApiResponse<?> process(String requestURI, Map<String, String> paramMap) {
        if (requestURI.endsWith("/type")) {
            return findDepositTypeByTermAndBankCode(paramMap);
        } else if (requestURI.endsWith("/period")) {
            return findDepositPeriodByTermAndBankCode(paramMap);
        } else {
            return new ApiResponse<>(HttpServletResponse.SC_NOT_FOUND, "요청한 URI가 존재하지 않습니다.");
        }
    }

    public ApiResponse<?> findDepositTypeByTermAndBankCode(Map<String, String> paramMap) {
        BankReqDto bankReqDto = new BankReqDto(paramMap.get("bankCode"), paramMap.get("term"),
                paramMap.get("stDate"), paramMap.get("endDate"));

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        DepositTypeListResDto depositTypeListResDto = depositInfoService.findDepositTypeByTermAndBankCode(bankReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, depositTypeListResDto);
    }

    public ApiResponse<?> findDepositPeriodByTermAndBankCode(Map<String, String> paramMap) {
        BankReqDto bankReqDto = new BankReqDto(paramMap.get("bankCode"), paramMap.get("term"),
                paramMap.get("stDate"), paramMap.get("endDate"));

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        DepositPeriodListResDto depositPeriodListResDto = depositInfoService.findDepositPeriodByTermAndBankCode(bankReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, depositPeriodListResDto);
    }
}
