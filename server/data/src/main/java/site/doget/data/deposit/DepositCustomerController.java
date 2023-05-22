package site.doget.data.deposit;

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

@RequestMapping("/api/deposit/customers")
@RequiredArgsConstructor
@Controller
public class DepositCustomerController {

    private final DepositCustomerService depositCustomerService;

    // 고객 종류별 예금 고객 수 조회
    @GetMapping("/type")
    public ResponseEntity<?> findDepositByCustomerType(BankReqDto bankReqDto) {

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ResponseEntity<>(validationResult.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        CustomerCountListByTypeResDto depositByCustomerType = depositCustomerService.findDepositByCustomerType(bankReqDto);

        return new ResponseEntity<>(depositByCustomerType, HttpStatus.OK);
    }

    // 금액별 예금 고객 수 조회
    @GetMapping("/amount")
    public ResponseEntity<?> findDepositByAmount(BankReqDto bankReqDto) {

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ResponseEntity<>(validationResult.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        CustomerCountListByAmountResDto depositByAmount = depositCustomerService.findDepositByAmount(bankReqDto);

        return new ResponseEntity<>(depositByAmount, HttpStatus.OK);
    }

    // 지역별 예금 고객 수 조회
    @GetMapping("/region")
    public ResponseEntity<?> findDepositByRegion(BankReqDto bankReqDto) {

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ResponseEntity<>(validationResult.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        CustomerCountByRegionDto depositByRegion = depositCustomerService.findDepositByRegion(bankReqDto);

        return new ResponseEntity<>(depositByRegion, HttpStatus.OK);
    }
}
