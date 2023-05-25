package site.doget.data.loan;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import site.doget.data.common.ValidationResult;
import site.doget.data.common.dto.BankReqDto;
import site.doget.data.common.dto.CustomerCountByRegionDto;
import site.doget.data.common.dto.CustomerCountListByAmountResDto;
import site.doget.data.common.dto.CustomerCountListByTypeResDto;


@RequestMapping("/api/loan/customers")
@RequiredArgsConstructor
@Controller
public class LoanCustomerController {

    private final LoanCustomerService loanCustomerService;

    // 고객 종류별 대출 고객 수 조회
    @GetMapping("/type")
    public ResponseEntity<?> findLoanByCustomerType(BankReqDto bankReqDto) {

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ResponseEntity<>(validationResult.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        CustomerCountListByTypeResDto loanByCustomerType = loanCustomerService.findLoanByCustomerType(bankReqDto);

        return new ResponseEntity<>(loanByCustomerType, HttpStatus.OK);
    }

    // 금액별 대출 고객 수 조회
    @GetMapping("/amount")
    public ResponseEntity<?> findLoanByAmount(BankReqDto bankReqDto) {

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ResponseEntity<>(validationResult.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        CustomerCountListByAmountResDto loanByAmount = loanCustomerService.findLoanByAmount(bankReqDto);

        return new ResponseEntity<>(loanByAmount, HttpStatus.OK);
    }

    // 지역별 대출 고객 수 조회
    @GetMapping("/region")
    public ResponseEntity<?> findLoanByRegion(BankReqDto bankReqDto) {

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ResponseEntity<>(validationResult.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        CustomerCountByRegionDto loanByRegion = loanCustomerService.findLoanByRegion(bankReqDto);

        return new ResponseEntity<>(loanByRegion, HttpStatus.OK);
    }

}
