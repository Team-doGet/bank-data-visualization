package site.doget.dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class LoanPeriodResDto {
    private String label;
    private ArrayList<Integer> data;

    public LoanPeriodResDto(String label, ArrayList<Integer> data) {
        this.label = label;
        this.data = data;
    }
}
