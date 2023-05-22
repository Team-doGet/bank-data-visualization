package site.doget.data.income;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import site.doget.data.common.ValidationResult;
import site.doget.data.common.dto.BankReqDto;
import site.doget.data.income.dto.IncomeListResDto;

@RequestMapping("/api/income")
@RequiredArgsConstructor
@Controller
public class IncomeController {

    private final IncomeService incomeService;

    @GetMapping("")
    public ResponseEntity<?> getFinancial(BankReqDto bankReqDto) {

        ValidationResult validationResult = bankReqDto.validate();

        if (!validationResult.isValid()) {
            return new ResponseEntity<>(validationResult.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        IncomeListResDto incomeListResDto = incomeService.findByTermAndBankCode(bankReqDto);

        return new ResponseEntity<>(incomeListResDto, HttpStatus.OK);
    }

}
