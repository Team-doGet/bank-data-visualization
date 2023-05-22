package site.doget.data.dto.raw;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCountByAmountRawDto {

    private String range;
    private String custDscdNm;
    private int count;
}
