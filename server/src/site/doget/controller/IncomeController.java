package site.doget.controller;

import site.doget.common.ApiResponse;
import site.doget.common.ValidationResult;
import site.doget.dto.IncomeListResDto;
import site.doget.dto.IncomeReqDto;
import site.doget.service.IncomeService;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class IncomeController implements Controller {

    IncomeService incomeService = IncomeService.getInstance();
    @Override
    public ApiResponse<?> process(Map<String, String> paramMap) {

        IncomeReqDto incomeReqDto = new IncomeReqDto(paramMap.get("bankCode"), paramMap.get("term"),
                paramMap.get("stDate"), paramMap.get("endDate"));

        ValidationResult validationResult = incomeReqDto.validate();

        if (!validationResult.isValid()) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, validationResult.getErrorMessage());
        }

        IncomeListResDto incomeListResDto = incomeService.findByTermAndBankCode(incomeReqDto);

        return new ApiResponse<>(HttpServletResponse.SC_OK, incomeListResDto);
    }
}
