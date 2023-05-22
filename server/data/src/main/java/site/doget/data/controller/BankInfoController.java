package site.doget.data.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.doget.data.dto.BankInfoResDto;
import site.doget.data.service.BankInfoService;

import java.util.regex.Pattern;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bank")
public class BankInfoController {

    private final BankInfoService bankInfoService;



    @GetMapping("/info")
    public ResponseEntity<?> getBankInfo(@RequestParam String bankCode) {

        if (!Pattern.matches("^\\d+$", bankCode)) {
            return new ResponseEntity<>("bankCode 파라미터는 숫자로 이루어져야 합니다.", HttpStatus.BAD_REQUEST);
        }

        BankInfoResDto infoByBankCode = bankInfoService.findInfoByBankCode(bankCode);
        return new ResponseEntity<>(infoByBankCode, HttpStatus.OK);
    }
}
