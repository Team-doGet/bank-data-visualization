package site.doget.dto;

import lombok.Getter;
import java.util.List;

@Getter
public class IncomeListResDto {

    private List<String> date;
    private List<IncomeResDto> datasets;

    public IncomeListResDto(List<String> date, List<IncomeResDto> datasets) {
        this.date = date;
        this.datasets = datasets;
    }
}