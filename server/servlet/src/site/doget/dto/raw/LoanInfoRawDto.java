package site.doget.dto.raw;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanInfoRawDto {
    private String baseYm;
    private String credMrtgNm;
    private String custDscdNm;
    private Integer cnt;
    private Long max;
    private Long avg;
    private Long mid;
    private Long mod;
}
