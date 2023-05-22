package site.doget.data.financial;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import site.doget.data.common.ValidationResult;
import site.doget.data.financial.dto.FinancialListResDto;
import site.doget.data.financial.dto.FinancialReqDto;

@RequestMapping("/api/financial")
@RequiredArgsConstructor
@Controller
public class FinancialController {
    private final FinancialService financialService;

    @GetMapping("")
    public ResponseEntity<?> getFinancial(FinancialReqDto financialReqDto) {

        ValidationResult validationResult = financialReqDto.validateWithAmountType();

        if (!validationResult.isValid()) {
            return new ResponseEntity<>(validationResult.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        FinancialListResDto financialListResDto = financialService.findByTermAndBankCode(financialReqDto);

        return new ResponseEntity<>(financialListResDto, HttpStatus.OK);
    }
}
