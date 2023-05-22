package site.doget.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.data.dto.BankReqDto;
import site.doget.data.dto.raw.LoanInfoRawDto;

import java.util.List;

@Mapper
public interface LoanInfoMapper {
    List<LoanInfoRawDto> findLoanGuaranteeByTermAndBankCode(BankReqDto bankReqDto);
    List<LoanInfoRawDto> findLoanPeriodByTermAndBankCode(BankReqDto bankReqDto);
    List<LoanInfoRawDto> findLoanStatsByTermAndBankCode(BankReqDto bankReqDto);
    List<LoanInfoRawDto> findLoanStatsModByTermAndBankCode(BankReqDto bankReqDto);
}
