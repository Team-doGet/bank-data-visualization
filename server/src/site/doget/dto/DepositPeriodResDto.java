package site.doget.dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class DepositPeriodResDto {
    private String label;
    private ArrayList<Integer> data;

    public DepositPeriodResDto(String label, ArrayList<Integer> data) {
        this.label = label;
        this.data = data;
    }
}
