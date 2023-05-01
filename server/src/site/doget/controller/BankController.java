package site.doget.controller;

import site.doget.common.ApiResponse;
import site.doget.repository.BankRepository;
import site.doget.dto.BankDto;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class BankController implements Controller {

    BankRepository bankRepository = BankRepository.getInstance();


    @Override
    public ApiResponse<BankDto> process(Map<String, String> paramMap) {

        BankDto bankDto = bankRepository.findByCode(10452);
        return new ApiResponse<>(HttpServletResponse.SC_OK, bankDto);
    }
}
