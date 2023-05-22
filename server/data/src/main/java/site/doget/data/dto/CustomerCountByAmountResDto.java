package site.doget.data.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CustomerCountByAmountResDto {

    private String label;
    private List<Integer> data;

    public CustomerCountByAmountResDto(String label, List<Integer> data) {
        this.label = label;
        this.data = data;
    }
}
