package site.doget.data.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class DepositPeriodListResDto {
    private List<String> labels;
    private List<DepositPeriodResDto> datasets;

    public DepositPeriodListResDto(List<String> labels, List<DepositPeriodResDto> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}
