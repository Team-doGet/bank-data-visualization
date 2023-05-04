package site.doget.dto;

import lombok.Getter;

import java.util.List;


@Getter
public class CustomerCountListByAmountResDto {

    private List<String> labels;
    private List<CustomerCountByAmountResDto> datasets;

    public CustomerCountListByAmountResDto(List<String> labels, List<CustomerCountByAmountResDto> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}
