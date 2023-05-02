package site.doget.controller;

import site.doget.common.ApiResponse;
import site.doget.dto.IncomeListDto;
import site.doget.service.IncomeService;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class IncomeController implements Controller {

    IncomeService incomeService = IncomeService.getInstance();
    @Override
    public ApiResponse<?> process(Map<String, String> paramMap) {

        IncomeListDto incomeListDto = incomeService.findByTermAndBankCode(paramMap);

        return new ApiResponse<>(HttpServletResponse.SC_OK, incomeListDto);
    }
}
