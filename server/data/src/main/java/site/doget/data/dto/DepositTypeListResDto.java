package site.doget.data.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class DepositTypeListResDto {
    private List<String> labels;
    private List<DepositTypeResDto> datasets;

    public DepositTypeListResDto(List<String> labels, List<DepositTypeResDto> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}
