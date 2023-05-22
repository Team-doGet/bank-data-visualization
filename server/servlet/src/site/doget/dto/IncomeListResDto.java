package site.doget.dto;

import lombok.Getter;
import java.util.List;

@Getter
public class IncomeListResDto {

    private List<String> labels;
    private List<IncomeResDto> datasets;

    public IncomeListResDto(List<String> labels, List<IncomeResDto> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}