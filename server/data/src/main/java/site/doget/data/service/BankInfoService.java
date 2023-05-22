package site.doget.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.doget.data.dto.BankInfoResDto;
import site.doget.data.dto.DateRange;
import site.doget.data.dto.raw.BankInfoRawDto;
import site.doget.data.mapper.BankInfoMapper;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BankInfoService {


    private final BankInfoMapper bankInfoMapper;


    public BankInfoResDto findInfoByBankCode(String bankCode) {

        List<BankInfoRawDto> bankInfoRawDtoList = bankInfoMapper.findByBankCode(bankCode);

        BankInfoResDto bankInfoResDto = new BankInfoResDto();

        bankInfoResDto.setName(bankInfoRawDtoList.get(0).getName());
        bankInfoRawDtoList.forEach(bankInfoRawDto -> {

            switch (bankInfoRawDto.getInfo()) {
                case "loanDate":
                    bankInfoResDto.setLoanDate(new DateRange(bankInfoRawDto.getMin(), bankInfoRawDto.getMax()));
                    break;
                case "depositDate":
                    bankInfoResDto.setDepositDate(new DateRange(bankInfoRawDto.getMin(), bankInfoRawDto.getMax()));
                    break;
                case "incomeDate":
                    bankInfoResDto.setIncomeDate(new DateRange(bankInfoRawDto.getMin(), bankInfoRawDto.getMax()));
                    break;
                case "financialDate":
                    bankInfoResDto.setFinancialDate(new DateRange(bankInfoRawDto.getMin(), bankInfoRawDto.getMax()));
                    break;
            }
        });

        return bankInfoResDto;
    }
}
