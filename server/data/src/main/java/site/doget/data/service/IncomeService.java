package site.doget.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.doget.data.common.CodeMapper;
import site.doget.data.dto.BankReqDto;
import site.doget.data.dto.IncomeListResDto;
import site.doget.data.dto.IncomeResDto;
import site.doget.data.dto.raw.PlosdocRawDto;
import site.doget.data.mapper.IncomeMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class IncomeService {

    private final IncomeMapper incomeMapper;

    public IncomeListResDto findByTermAndBankCode(BankReqDto bankReqDto) {

        List<PlosdocRawDto> plosdocRawDtoList = incomeMapper.findByTermAndBankCode(bankReqDto);


        // IncomeListResDto
        List<String> labels = new ArrayList<>();
        List<IncomeResDto> datasets = new ArrayList<>();

        // IncomeResDto List 객체 생성
        String[] codes = CodeMapper.incomeMap.keySet().toArray(new String[0]);
        Arrays.sort(codes);

        for (String code : codes) {
            datasets.add(new IncomeResDto(code, CodeMapper.incomeMap.get(code), new ArrayList<>()));
            }

        // datasets 추가
        for (PlosdocRawDto plosdocRawDto : plosdocRawDtoList) {
            labels.add(plosdocRawDto.getBaseYm());
            for (int i = 0; i < codes.length; i++) {
                datasets.get(i).getData().add(plosdocRawDto.getValueByCode(codes[i]));
            }
            }

        return new IncomeListResDto(labels, datasets);
    }

}
