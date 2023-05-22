package site.doget.data.deposit;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import site.doget.data.common.dto.BankReqDto;
import site.doget.data.common.ValidationResult;
import site.doget.data.deposit.dto.DepositPeriodListResDto;
import site.doget.data.deposit.dto.DepositStatsListResDto;
import site.doget.data.deposit.dto.DepositTypeListResDto;

@RequestMapping("/api/deposit")
@RequiredArgsConstructor
@Controller
public class DepositInfoController {

    private final DepositInfoService depositInfoService;

    @GetMapping("/type")
    public ResponseEntity<?> findDepositTypeByTermAndBankCode(BankReqDto bankReqDto) {

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ResponseEntity<>(validationResult.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        DepositTypeListResDto depositTypeListResDto = depositInfoService.findDepositTypeByTermAndBankCode(bankReqDto);

        return new ResponseEntity<>(depositTypeListResDto, HttpStatus.OK);
    }

    @GetMapping("/period")
    public ResponseEntity<?> findDepositPeriodByTermAndBankCode(BankReqDto bankReqDto) {

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ResponseEntity<>(validationResult.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        DepositPeriodListResDto depositPeriodListResDto = depositInfoService.findDepositPeriodByTermAndBankCode(bankReqDto);

        return new ResponseEntity<>(depositPeriodListResDto, HttpStatus.OK);
    }

    @GetMapping("/stats")
    public ResponseEntity<?> findDepositStatsByTermAndBankCode(BankReqDto bankReqDto) {

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ResponseEntity<>(validationResult.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        DepositStatsListResDto depositStatsListResDto = depositInfoService.findDepositStatsByTermAndBankCode(bankReqDto);

        return new ResponseEntity<>(depositStatsListResDto, HttpStatus.OK);
    }
}
