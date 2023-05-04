package site.doget.dto;

import lombok.Getter;

import java.util.List;

/**
 * 고객 종류별 비교 리스트 (개인-법인 비교)
 */
@Getter
public class CustTypeCompListResDto {

    private String title;
    private List<String> labels;
    private List<CustTypeCompResDto> datasets;

    public CustTypeCompListResDto(String title, List<String> labels, List<CustTypeCompResDto> datasets) {
        this.title = title;
        this.labels = labels;
        this.datasets = datasets;
    }
}
