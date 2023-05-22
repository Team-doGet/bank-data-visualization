package site.doget.data.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class LoanGuaranteeListResDto {
    private List<String> labels;
    private List<LoanGuaranteeResDto> datasets;

    public LoanGuaranteeListResDto(List<String> labels, List<LoanGuaranteeResDto> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}
