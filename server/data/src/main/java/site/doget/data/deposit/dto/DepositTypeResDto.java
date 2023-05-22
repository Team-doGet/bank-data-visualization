package site.doget.data.deposit.dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class DepositTypeResDto {
    private String label;
    private ArrayList<Integer> data;

    public DepositTypeResDto(String label, ArrayList<Integer> data) {
        this.label = label;
        this.data = data;
    }
}
