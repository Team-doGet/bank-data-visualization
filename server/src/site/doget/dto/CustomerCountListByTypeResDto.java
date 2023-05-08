package site.doget.dto;

import lombok.Getter;

import java.util.List;


@Getter
public class CustomerCountListByTypeResDto {

    private List<String> labels;
    private List<CustomerCountByTypeResDto> datasets;

    public CustomerCountListByTypeResDto(List<String> labels, List<CustomerCountByTypeResDto> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}
