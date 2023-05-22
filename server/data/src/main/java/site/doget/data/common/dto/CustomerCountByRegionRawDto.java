package site.doget.data.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCountByRegionRawDto {

    private String custLctplcNm;    // 지역
    private int count;
}
