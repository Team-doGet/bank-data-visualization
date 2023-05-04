package site.doget.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CustomerCountByTypeResDto {

    private String label;
    private List<String> data;

    public CustomerCountByTypeResDto(String label, List<String> data) {
        this.label = label;
        this.data = data;
    }
}
