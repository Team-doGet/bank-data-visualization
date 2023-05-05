package site.doget.dto;

import java.util.List;

public class CustomerCountByRegionDto {

    private String labels;
    private List<Integer> datasets;


    public CustomerCountByRegionDto(String labels, List<Integer> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}
