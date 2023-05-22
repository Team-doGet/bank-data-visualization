package site.doget.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.doget.data.dto.*;
import site.doget.data.dto.raw.LoanInfoRawDto;
import site.doget.data.mapper.LoanInfoMapper;

import java.util.*;

@RequiredArgsConstructor
@Service
public class LoanInfoService {

    private final LoanInfoMapper loanInfoMapper;

    public LoanGuaranteeListResDto findLoanGuaranteeByTermAndBankCode(BankReqDto bankReqDto) {

        List<LoanInfoRawDto> loanInfoRawDtoList = loanInfoMapper.findLoanGuaranteeByTermAndBankCode(bankReqDto);

        List<String> labels = new ArrayList<>();
        List<LoanGuaranteeResDto> datasets = new ArrayList<>();

        Set<String> guranteeSet = new HashSet<String>();
        for (LoanInfoRawDto loanInfoRawDto : loanInfoRawDtoList) {
            guranteeSet.add(loanInfoRawDto.getCredMrtgNm());
        }
        String[] guaranteeTypeList = guranteeSet.toArray(new String[guranteeSet.size()]);

        Set<String> baseYmSet = new HashSet<String>();
        for (LoanInfoRawDto loanInfoRawDto : loanInfoRawDtoList) {
            baseYmSet.add(loanInfoRawDto.getBaseYm());
        }
        String[] labelList = baseYmSet.toArray(new String[baseYmSet.size()]);
        Arrays.sort(labelList);
        labels = List.of(labelList);

        for (String guaranteeType : guaranteeTypeList) {
            datasets.add(new LoanGuaranteeResDto(guaranteeType, new ArrayList<>()));
        }

        List<Integer> cntList = new ArrayList<Integer >();
        for (LoanInfoRawDto loanInfoRawDto : loanInfoRawDtoList) {
            cntList.add(loanInfoRawDto.getCnt());
        }

        int k = 0;
        for (int i = 0; i < guaranteeTypeList.length; i++) {
            for (int j = 0; j < loanInfoRawDtoList.size() / guaranteeTypeList.length; j++) {
                if (k >= cntList.size()) break;
                datasets.get(i).getData().add(cntList.get(k++));
            }
        }

        return new LoanGuaranteeListResDto(labels, datasets);
    }


    public LoanPeriodListResDto findLoanPeriodByTermAndBankCode(BankReqDto bankReqDto) {

        List<LoanInfoRawDto> loanInfoRawDtoList = loanInfoMapper.findLoanPeriodByTermAndBankCode(bankReqDto);

        List<String> labels = new ArrayList<>();
        List<LoanPeriodResDto> datasets = new ArrayList<>();

        Set<String> custTypeSet = new HashSet<String>();
        for (LoanInfoRawDto loanInfoRawDto : loanInfoRawDtoList) {
            custTypeSet.add(loanInfoRawDto.getCustDscdNm());
        }
        String[] custTypeList = custTypeSet.toArray(new String[custTypeSet.size()]);
        Arrays.sort(custTypeList);

        Set<String> baseYmSet = new HashSet<String>();
        for (LoanInfoRawDto loanInfoRawDto : loanInfoRawDtoList) {
            baseYmSet.add(loanInfoRawDto.getBaseYm());
        }
        String[] labelList = baseYmSet.toArray(new String[baseYmSet.size()]);
        Arrays.sort(labelList);
        labels = List.of(labelList);

        for (String custType : custTypeList) {
            datasets.add(new LoanPeriodResDto(custType, new ArrayList<>()));
        }

        List<Integer> cntList = new ArrayList<Integer >();
        for (LoanInfoRawDto loanInfoRawDto : loanInfoRawDtoList) {
            cntList.add(loanInfoRawDto.getCnt());
        }

        int k = 0;
        for (int i = 0; i < custTypeList.length; i++) {
            for (int j = 0; j < loanInfoRawDtoList.size() / custTypeList.length; j++) {
                if (k >= cntList.size()) break;
                datasets.get(i).getData().add(cntList.get(k++));
            }
        }

        return new LoanPeriodListResDto(labels, datasets);
    }

    public LoanStatsListResDto findLoanStatsByTermAndBankCode(BankReqDto bankReqDto) {

        List<LoanInfoRawDto> loanInfoStatsRawDtoList = loanInfoMapper.findLoanStatsByTermAndBankCode(bankReqDto);
        List<LoanInfoRawDto> loanInfoStatsModRawDtoList = loanInfoMapper.findLoanStatsModByTermAndBankCode(bankReqDto);

        List<String> labels = new ArrayList<>();
        List<LoanStatsResDto> datasets = new ArrayList<>();

        for (LoanInfoRawDto loanInfoRawDto : loanInfoStatsRawDtoList) {
            labels.add(loanInfoRawDto.getBaseYm());
        }

        String[] statsType =  {"최댓값", "평균값", "중앙값", "최빈값"};
        for (String stats : statsType) {
            datasets.add(new LoanStatsResDto(stats, new ArrayList<>()));
        }

        for (LoanInfoRawDto loanInfoStatsRawDto : loanInfoStatsRawDtoList) {
            datasets.get(0).getData().add(loanInfoStatsRawDto.getMax());
            datasets.get(1).getData().add(loanInfoStatsRawDto.getAvg());
            datasets.get(2).getData().add(loanInfoStatsRawDto.getMid());
        }
        for (LoanInfoRawDto loanInfoStatsModRawDto : loanInfoStatsModRawDtoList) {
            datasets.get(3).getData().add(loanInfoStatsModRawDto.getMod());
        }

        return new LoanStatsListResDto(labels, datasets);
    }
}
