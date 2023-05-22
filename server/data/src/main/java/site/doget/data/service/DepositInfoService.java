package site.doget.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.doget.data.dto.*;
import site.doget.data.dto.raw.DepositInfoRawDto;
import site.doget.data.mapper.DepositInfoMapper;

import java.util.*;

@RequiredArgsConstructor
@Service
public class DepositInfoService {

    private final DepositInfoMapper depositInfoMapper;

    public DepositTypeListResDto findDepositTypeByTermAndBankCode(BankReqDto bankReqDto) {

        List<DepositInfoRawDto> depositInfoRawDtoList = depositInfoMapper.findDepositTypeByTermAndBankCode(bankReqDto);

        List<String> labels = new ArrayList<>();
        List<DepositTypeResDto> datasets = new ArrayList<>();

        Set<String> baseYmSet = new HashSet<String>();
        for (DepositInfoRawDto depositInfoRawDto : depositInfoRawDtoList) {
            baseYmSet.add(depositInfoRawDto.getBaseYm());
        }
        String[] labelList = baseYmSet.toArray(new String[baseYmSet.size()]);
        Arrays.sort(labelList);
        labels = List.of(labelList);

        Set<String> typeSet = new HashSet<String>();
        for (DepositInfoRawDto depositInfoRawDto : depositInfoRawDtoList) {
            typeSet.add(depositInfoRawDto.getAccSbjcNm());
        }
        String[] depositTypeList = typeSet.toArray(new String[typeSet.size()]);
        Arrays.sort(depositTypeList);
        for (String depositType : depositTypeList) {
            datasets.add(new DepositTypeResDto(depositType, new ArrayList<>(Collections.nCopies(labels.size(), 0))));
        }

        for (DepositInfoRawDto depositInfoRawDto : depositInfoRawDtoList) {
            String type = depositInfoRawDto.getAccSbjcNm();
            int idx = labels.indexOf(depositInfoRawDto.getBaseYm());
            for (DepositTypeResDto dataset : datasets) {
                if (type.equals(dataset.getLabel())) {
                    dataset.getData().set(idx, depositInfoRawDto.getCnt());
                    break;
                }
            }
        }

        return new DepositTypeListResDto(labels, datasets);
    }

    public DepositPeriodListResDto findDepositPeriodByTermAndBankCode(BankReqDto bankReqDto) {

        List<DepositInfoRawDto> depositInfoRawDtoList = depositInfoMapper.findDepositPeriodByTermAndBankCode(bankReqDto);

        List<String> labels = new ArrayList<>();
        List<DepositPeriodResDto> datasets = new ArrayList<>();


        Set<String> custTypeSet = new HashSet<String>();
        for (DepositInfoRawDto depositInfoRawDto : depositInfoRawDtoList) {
            custTypeSet.add(depositInfoRawDto.getCustDscdNm());
        }
        String[] depositCustTypeList = custTypeSet.toArray(new String[custTypeSet.size()]);
        Arrays.sort(depositCustTypeList);

        Set<String> baseYmSet = new HashSet<String>();
        for (DepositInfoRawDto depositInfoRawDto : depositInfoRawDtoList) {
            baseYmSet.add(depositInfoRawDto.getBaseYm());
        }
        String[] labelList = baseYmSet.toArray(new String[baseYmSet.size()]);
        Arrays.sort(labelList);
        labels = List.of(labelList);

        for (String depositCustType : depositCustTypeList) {
            datasets.add(new DepositPeriodResDto(depositCustType, new ArrayList<>()));
        }

        List<Integer> cntList = new ArrayList<Integer>();
        for (DepositInfoRawDto depositInfoRawDto : depositInfoRawDtoList) {
            cntList.add(depositInfoRawDto.getCnt());
        }

        int k = 0;
        for (int i = 0; i < depositCustTypeList.length; i++) {
            for (int j = 0; j < depositInfoRawDtoList.size() / depositCustTypeList.length; j++) {
                if (k >= cntList.size()) break;
                datasets.get(i).getData().add(cntList.get(k++));
            }
        }

        return new DepositPeriodListResDto(labels, datasets);
    }

    public DepositStatsListResDto findDepositStatsByTermAndBankCode(BankReqDto bankReqDto) {

        List<DepositInfoRawDto> depositInfoStatsRawDtoList = depositInfoMapper.findDepositStatsByTermAndBankCode(bankReqDto);
        List<DepositInfoRawDto> depositInfoStatsModRawDtoList = depositInfoMapper.findDepositStatsModByTermAndBankCode(bankReqDto);

        List<String> labels = new ArrayList<>();
        List<DepositStatsResDto> datasets = new ArrayList<>();

        for (DepositInfoRawDto depositInfoRawDto : depositInfoStatsRawDtoList) {
            labels.add(depositInfoRawDto.getBaseYm());
        }

        String[] statsType = {"최댓값", "평균값", "중앙값", "최빈값"};
        for (String stats : statsType) {
            datasets.add(new DepositStatsResDto(stats, new ArrayList<>()));
        }

        for (DepositInfoRawDto depositInfoRawDto : depositInfoStatsRawDtoList) {
            datasets.get(0).getData().add(depositInfoRawDto.getMax());
            datasets.get(1).getData().add(depositInfoRawDto.getAvg());
            datasets.get(2).getData().add(depositInfoRawDto.getMid());
        }
        for (DepositInfoRawDto depositInfoRawDto : depositInfoStatsModRawDtoList) {
            datasets.get(3).getData().add(depositInfoRawDto.getMod());
        }

        return new DepositStatsListResDto(labels, datasets);
    }
}