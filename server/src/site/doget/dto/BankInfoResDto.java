package site.doget.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankInfoResDto {
    private String name;
    private DateRange loanDate;
    private DateRange depositDate;
    private DateRange incomeDate;
    private DateRange financialDate;

}
