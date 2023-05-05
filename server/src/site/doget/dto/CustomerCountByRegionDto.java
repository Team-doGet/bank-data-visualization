package site.doget.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CustomerCountByRegionDto {

    private List<String> labels;
    private List<Integer> datasets;


    public CustomerCountByRegionDto(List<String> labels, List<Integer> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}
