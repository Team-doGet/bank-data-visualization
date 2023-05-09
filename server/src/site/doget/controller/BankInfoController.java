package site.doget.controller;

import site.doget.common.ApiResponse;
import site.doget.dto.BankInfoResDto;
import site.doget.service.BankInfoService;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.regex.Pattern;

public class BankInfoController implements Controller {

    BankInfoService bankInfoService = BankInfoService.getInstance();

    @Override
    public ApiResponse<?> process(String requestURI, Map<String, String> paramMap) {


        String bankCode = paramMap.get("bankCode");

        if (!Pattern.matches("^\\d+$", bankCode)) {
            return new ApiResponse<>(HttpServletResponse.SC_BAD_REQUEST, "bankCode 파라미터는 숫자로 이루어져야 합니다.");
        }

        BankInfoResDto infoByBankCode = bankInfoService.findInfoByBankCode(bankCode);

        return new ApiResponse<>(HttpServletResponse.SC_OK, infoByBankCode);
    }
}
