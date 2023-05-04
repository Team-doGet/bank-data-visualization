package site.doget.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CustTypeCompResDto {

    private String label;
    private List<String> data;

    public CustTypeCompResDto(String label, List<String> data) {
        this.label = label;
        this.data = data;
    }
}
