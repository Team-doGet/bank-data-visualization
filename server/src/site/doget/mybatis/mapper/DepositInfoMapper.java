package site.doget.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.dto.BankReqDto;
import site.doget.dto.raw.DepositInfoRawDto;
import java.util.List;

@Mapper
public interface DepositInfoMapper {
    List<DepositInfoRawDto> findDepositTypeByTermAndBankCode(BankReqDto bankReqDto);
    List<DepositInfoRawDto> findDepositPeriodByTermAndBankCode(BankReqDto bankReqDto);
    List<DepositInfoRawDto> findDepositStatsByTermAndBankCode(BankReqDto bankReqDto);
    List<DepositInfoRawDto> findDepositStatsModByTermAndBankCode(BankReqDto bankReqDto);
}
