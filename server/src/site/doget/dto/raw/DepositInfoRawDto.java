package site.doget.dto.raw;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepositInfoRawDto {
    private String baseYm;
    private String accSbjcNm;
    private Integer cnt;
    private Integer max;
    private Integer avg;
    private Integer mid;
    private Integer mod;
}
