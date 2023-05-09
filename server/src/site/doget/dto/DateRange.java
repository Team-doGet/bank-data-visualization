package site.doget.dto;

import lombok.Getter;

@Getter
public class DateRange {

    private String min;
    private String max;

    public DateRange(String min, String max) {
        this.min = min;
        this.max = max;
    }
}
