package site.doget.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CustomerCountByAmountResDto {

    private String label;
    private List<String> data;

    public CustomerCountByAmountResDto(String label, List<String> data) {
        this.label = label;
        this.data = data;
    }
}
