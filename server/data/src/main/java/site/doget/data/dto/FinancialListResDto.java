package site.doget.data.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class FinancialListResDto {
    private List<String> labels;
    private List<FinancialResDto> datasets;

    public FinancialListResDto(List<String> labels, List<FinancialResDto> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}
