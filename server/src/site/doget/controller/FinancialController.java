package site.doget.controller;

import site.doget.common.ApiResponse;
import site.doget.common.ValidationResult;
import site.doget.dto.FinancialListResDto;
import site.doget.dto.FinancialReqDto;
import site.doget.dto.FinancialResDto;
import site.doget.service.FinancialService;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class FinancialController implements Controller {
    FinancialService financialService = FinancialService.getInstance();
    @Override
    public ApiResponse<?> process(Map<String, String> paramMap) {
        FinancialReqDto financialReqDto = new FinancialReqDto(paramMap.get("term"),paramMap.get("bankCode"),
                paramMap.get("stDate"), paramMap.get("endDate"), paramMap.get("amountType"));

        ValidationResult validationResult = financialReqDto.validateWithAmountType();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        FinancialListResDto financialListResDto = financialService.findByTermAndBankCode(financialReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, financialListResDto);
    }
}
