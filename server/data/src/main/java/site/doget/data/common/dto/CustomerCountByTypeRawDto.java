package site.doget.data.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCountByTypeRawDto {

    private String newDt;
    private String custDscdNm;
    private int count;
}
