package site.doget.dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class FinancialResDto {
    private String code;
    private String label;
    private ArrayList<Integer> data;

    public FinancialResDto(String code, String label, ArrayList<Integer> data) {
        this.code = code;
        this.label = label;
        this.data = data;
    }
}