package site.doget.dto;

import lombok.Getter;

import java.util.List;


@Getter
public class CustomerCountListResDto {

    private List<String> dates;
    private List<CustomerCountResDto> datasets;

    public CustomerCountListResDto(List<String> dates, List<CustomerCountResDto> datasets) {
        this.dates = dates;
        this.datasets = datasets;
    }
}
