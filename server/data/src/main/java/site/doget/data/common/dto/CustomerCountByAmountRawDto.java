package site.doget.data.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCountByAmountRawDto {

    private String range;
    private String custDscdNm;
    private int count;
}
