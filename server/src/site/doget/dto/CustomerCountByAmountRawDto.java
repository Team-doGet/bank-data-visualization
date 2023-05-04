package site.doget.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCountByAmountRawDto {

    private String range;
    private String custDscdNm;
    private String count;
}
