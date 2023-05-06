package site.doget.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class LoanPeriodListResDto {
    private List<String> labels;
    private List<LoanPeriodResDto> datasets;

    public LoanPeriodListResDto(List<String> labels, List<LoanPeriodResDto> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}
