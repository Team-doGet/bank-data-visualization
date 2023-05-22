package site.doget.data.dto;

import site.doget.data.common.ValidationResult;

public class FinancialReqDto extends BankReqDto {
    private final String amountType;
    public FinancialReqDto(String term, String bankCode, String stDate, String endDate, String amountType) {
        super(bankCode, term, stDate, endDate);
        this.amountType = amountType;
    }

    public ValidationResult validateWithAmountType() {
        if (!validate().isValid()) return validate();

        if (!("0".equals(amountType) || "1".equals(amountType))) {
            return new ValidationResult(false, "amountType 파라미터는 0, 1 중 하나여야 합니다.");
        }

        return new ValidationResult(true, "");
    }
}
