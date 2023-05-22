package site.doget.data.loan.dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class LoanGuaranteeResDto {
    private String label;
    private ArrayList<Integer> data;

    public LoanGuaranteeResDto(String label, ArrayList<Integer> data) {
        this.label = label;
        this.data = data;
    }
}
