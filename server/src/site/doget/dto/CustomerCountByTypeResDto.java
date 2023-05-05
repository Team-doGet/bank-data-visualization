package site.doget.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CustomerCountByTypeResDto {

    private String label;
    private List<Integer> data;

    public CustomerCountByTypeResDto(String label, List<Integer> data) {
        this.label = label;
        this.data = data;
    }
}
