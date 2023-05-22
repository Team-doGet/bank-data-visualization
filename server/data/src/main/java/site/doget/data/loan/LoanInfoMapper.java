package site.doget.data.loan;

import org.apache.ibatis.annotations.Mapper;
import site.doget.data.common.dto.BankReqDto;
import site.doget.data.loan.dto.LoanInfoRawDto;

import java.util.List;

@Mapper
public interface LoanInfoMapper {
    List<LoanInfoRawDto> findLoanGuaranteeByTermAndBankCode(BankReqDto bankReqDto);
    List<LoanInfoRawDto> findLoanPeriodByTermAndBankCode(BankReqDto bankReqDto);
    List<LoanInfoRawDto> findLoanStatsByTermAndBankCode(BankReqDto bankReqDto);
    List<LoanInfoRawDto> findLoanStatsModByTermAndBankCode(BankReqDto bankReqDto);
}
