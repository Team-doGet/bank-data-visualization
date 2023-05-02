package site.doget.dto;

import lombok.Getter;
import java.util.List;

@Getter
public class IncomeListDto {

    private List<String> date;
    private List<IncomeDto> datasets;

    public IncomeListDto(List<String> date, List<IncomeDto> datasets) {
        this.date = date;
        this.datasets = datasets;
    }
}