package site.doget.data.income.dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class IncomeResDto {

    private String code;
    private String label;
    private ArrayList<Integer> data;

    public IncomeResDto(String code, String label, ArrayList<Integer> data) {
        this.code = code;
        this.label = label;
        this.data = data;
    }
}
