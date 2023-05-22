package site.doget.data.loan.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class LoanStatsListResDto {
    private List<String> labels;
    private List<LoanStatsResDto> datasets;

    public LoanStatsListResDto(List<String> labels, List<LoanStatsResDto> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}
