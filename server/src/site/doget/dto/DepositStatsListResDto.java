package site.doget.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class DepositStatsListResDto {
    private List<String> labels;
    private List<DepositStatsResDto> datasets;

    public DepositStatsListResDto(List<String> labels, List<DepositStatsResDto> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}
