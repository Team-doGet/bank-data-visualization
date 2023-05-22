package site.doget.data.loan.dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class LoanStatsResDto {
    private String label;
    private ArrayList<Long> data;

    public LoanStatsResDto(String label, ArrayList<Long> data) {
        this.label = label;
        this.data = data;
    }
}
