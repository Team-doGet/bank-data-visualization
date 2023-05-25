package site.doget.data.financial;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.doget.data.common.CodeMapper;
import site.doget.data.financial.dto.FinancialListResDto;
import site.doget.data.financial.dto.FinancialReqDto;
import site.doget.data.financial.dto.FinancialResDto;
import site.doget.data.financial.dto.FnnrRawDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FinancialService {

    private final FinancialMapper financialMapper;

    public FinancialListResDto findByTermAndBankCode(FinancialReqDto financialReqDto) {
        List<FnnrRawDto> fnnrRawDtoList = financialMapper.findByTermAndBankCode(financialReqDto);

        // FinancialListResDto
        List<String> labels = new ArrayList<>();
        List<FinancialResDto> datasets = new ArrayList<>();

        // FinancialResDto
        String[] codes = CodeMapper.financialMap.keySet().toArray(new String[0]);
        Arrays.sort(codes);

        for (String code : codes) {
            datasets.add(new FinancialResDto(code, CodeMapper.financialMap.get(code), new ArrayList<>()));
        }

        for (FnnrRawDto fnnrRawDto : fnnrRawDtoList) {
            labels.add(fnnrRawDto.getBaseYm());
            for (int i = 0; i < codes.length; i++) {
                datasets.get(i).getData().add(fnnrRawDto.getValueByCode(codes[i]));
            }
        }

        return new FinancialListResDto(labels, datasets);
    }
}