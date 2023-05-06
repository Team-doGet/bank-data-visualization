package site.doget.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.dto.BankReqDto;
import site.doget.dto.raw.DepositInfoRawDto;
import site.doget.dto.raw.LoanInfoRawDto;
import java.util.List;

@Mapper
public interface DepositInfoMapper {
    List<DepositInfoRawDto> findDepositTypeByTermAndBankCode(BankReqDto bankReqDto);
    List<DepositInfoRawDto> findDepositPeriodByTermAndBankCode(BankReqDto bankReqDto);
    List<LoanInfoRawDto> findPeriodInterestByTermAndBankCode(BankReqDto bankReqDto);
    List<LoanInfoRawDto> findPeriodStatsByTermAndBankCode(BankReqDto bankReqDto);
}
