package site.doget.dto;

import lombok.Getter;
import java.util.List;

@Getter
public class FinancialListResDto {
    private List<String> date;
    private List<FinancialResDto> datasets;

    public FinancialListResDto(List<String> date, List<FinancialResDto> datasets) {
        this.date = date;
        this.datasets = datasets;
    }
}
