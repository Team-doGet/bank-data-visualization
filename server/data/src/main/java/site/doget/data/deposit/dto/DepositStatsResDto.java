package site.doget.data.deposit.dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class DepositStatsResDto {
    private String label;
    private ArrayList<Long> data;

    public DepositStatsResDto(String label, ArrayList<Long> data) {
        this.label = label;
        this.data = data;
    }
}
