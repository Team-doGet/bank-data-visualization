package site.doget.data.deposit;

import org.apache.ibatis.annotations.Mapper;
import site.doget.data.common.dto.BankReqDto;
import site.doget.data.deposit.dto.DepositInfoRawDto;

import java.util.List;

@Mapper
public interface DepositInfoMapper {
    List<DepositInfoRawDto> findDepositTypeByTermAndBankCode(BankReqDto bankReqDto);
    List<DepositInfoRawDto> findDepositPeriodByTermAndBankCode(BankReqDto bankReqDto);
    List<DepositInfoRawDto> findDepositStatsByTermAndBankCode(BankReqDto bankReqDto);
    List<DepositInfoRawDto> findDepositStatsModByTermAndBankCode(BankReqDto bankReqDto);
}
