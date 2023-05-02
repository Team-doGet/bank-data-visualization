package site.doget.dto;

import lombok.Getter;
import java.util.ArrayList;

@Getter
public class IncomeDto {

    private String code;
    private String label;
    private ArrayList<String> data;

    public IncomeDto(String code, String label, ArrayList<String> data) {
        this.code = code;
        this.label = label;
        this.data = data;
    }
}
