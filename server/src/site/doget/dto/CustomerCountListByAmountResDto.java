package site.doget.dto;

import lombok.Getter;

import java.util.List;


@Getter
public class CustomerCountListByAmountResDto {

    private List<String> dates;
    private List<CustomerCountByAmountResDto> datasets;

    public CustomerCountListByAmountResDto(List<String> dates, List<CustomerCountByAmountResDto> datasets) {
        this.dates = dates;
        this.datasets = datasets;
    }
}
