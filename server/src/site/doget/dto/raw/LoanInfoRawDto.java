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
    private Integer max;
    private Integer avg;
    private Integer mid;
    private Integer mod;
}
