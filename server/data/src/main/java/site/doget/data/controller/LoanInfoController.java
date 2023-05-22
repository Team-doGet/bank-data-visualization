package site.doget.data.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import site.doget.data.common.ValidationResult;
import site.doget.data.dto.BankReqDto;
import site.doget.data.dto.LoanGuaranteeListResDto;
import site.doget.data.dto.LoanPeriodListResDto;
import site.doget.data.dto.LoanStatsListResDto;
import site.doget.data.service.LoanInfoService;


@RequestMapping("/api/loan")
@RequiredArgsConstructor
@Controller
public class LoanInfoController {
    private final LoanInfoService loanInfoService;

    @GetMapping("/guarantee")
    public ResponseEntity<?> findLoanGuaranteeByTermAndBankCode(BankReqDto bankReqDto) {

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ResponseEntity<>(validationResult.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        LoanGuaranteeListResDto loanGuaranteeListResDto = loanInfoService.findLoanGuaranteeByTermAndBankCode(bankReqDto);

        return new ResponseEntity<>(loanGuaranteeListResDto, HttpStatus.OK);
    }

    @GetMapping("/period")
    public ResponseEntity<?> findLoanPeriodByTermAndBankCode(BankReqDto bankReqDto) {

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ResponseEntity<>(validationResult.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        LoanPeriodListResDto loanPeriodListResDto = loanInfoService.findLoanPeriodByTermAndBankCode(bankReqDto);

        return new ResponseEntity<>(loanPeriodListResDto, HttpStatus.OK);
    }

    @GetMapping("/stats")
    public ResponseEntity<?> findLoanStatsByTermAndBankCode(BankReqDto bankReqDto) {

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ResponseEntity<>(validationResult.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        LoanStatsListResDto loanStatsListResDto = loanInfoService.findLoanStatsByTermAndBankCode(bankReqDto);

        return new ResponseEntity<>(loanStatsListResDto, HttpStatus.OK);
    }
}
