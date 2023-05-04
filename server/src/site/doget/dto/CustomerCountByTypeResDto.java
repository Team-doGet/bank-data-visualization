package site.doget.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CustomerCountByResDto {

    private String label;
    private List<String> data;

    public CustomerCountByResDto(String label, List<String> data) {
        this.label = label;
        this.data = data;
    }
}
