package site.doget.dto;

import lombok.Getter;

import java.util.List;

/**
 * 고객 종류별 비교 리스트 (개인-법인 비교)
 */
@Getter
public class CustTypeCompListResDto {

    private String title = "개인-법인 비교";
    private List<String> dates;
    private List<CustTypeCompResDto> datasets;

    public CustTypeCompListResDto(List<String> dates, List<CustTypeCompResDto> datasets) {
        this.dates = dates;
        this.datasets = datasets;
    }
}
