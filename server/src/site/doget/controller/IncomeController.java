package site.doget.controller;

import site.doget.common.ApiResponse;
import site.doget.common.ValidationResult;
import site.doget.dto.IncomeListResDto;
import site.doget.dto.BankReqDto;
import site.doget.service.IncomeService;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class IncomeController implements Controller {

    IncomeService incomeService = IncomeService.getInstance();
    @Override
    public ApiResponse<?> process(String requestURI, Map<String, String> paramMap) {

        BankReqDto bankReqDto = new BankReqDto(paramMap.get("bankCode"), paramMap.get("term"),
                paramMap.get("stDate"), paramMap.get("endDate"));

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        IncomeListResDto incomeListResDto = incomeService.findByTermAndBankCode(bankReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, incomeListResDto);
    }
}
