package site.doget.dto;

import lombok.Getter;

import java.util.List;


@Getter
public class CustomerCountListByTypeResDto {

    private List<String> dates;
    private List<CustomerCountByTypeResDto> datasets;

    public CustomerCountListByTypeResDto(List<String> dates, List<CustomerCountByTypeResDto> datasets) {
        this.dates = dates;
        this.datasets = datasets;
    }
}
