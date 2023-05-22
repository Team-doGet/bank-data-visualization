package site.doget.data.dto;

import site.doget.common.ValidationResult;

import java.util.regex.Pattern;

public class BankReqDto {

    private final String bankCode;
    private final String term;
    private final String stDate;
    private final String endDate;

    public BankReqDto(String bankCode, String term, String stDate, String endDate) {
        this.bankCode = bankCode;
        this.term = term;
        this.stDate = stDate;
        this.endDate = endDate;
    }

    public ValidationResult validate() {

        if (bankCode == null || term == null || stDate == null || endDate == null) {
            return new ValidationResult(false, "필수 파라미터가 누락되었습니다.");
        }

        if (!Pattern.matches("^\\d+$", bankCode)) {
            return new ValidationResult(false, "bankCode 파라미터는 숫자로 이루어져야 합니다.");
        }

        if (!Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", stDate) || !Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", endDate)) {
            return new ValidationResult(false, "날짜 형식은 yyyy-MM-dd와 일치해야 합니다.");
        }

        if (!"yearly".equals(term) && !"quarterly".equals(term) && !"monthly".equals(term)) {
            return new ValidationResult(false, "term 파라미터는 yearly, quarterly, monthly 중 하나여야 합니다.");
        }

        return new ValidationResult(true, "");
    }
}