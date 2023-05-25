package site.doget.data.loan;

import org.apache.ibatis.annotations.Mapper;
import site.doget.data.common.dto.BankReqDto;
import site.doget.data.common.dto.CustomerCountByAmountRawDto;
import site.doget.data.common.dto.CustomerCountByRegionRawDto;
import site.doget.data.common.dto.CustomerCountByTypeRawDto;

import java.util.List;

@Mapper
public interface LoanCustomerMapper {

    List<CustomerCountByTypeRawDto> findLoanByCustomerType(BankReqDto bankReqDto);
    List<CustomerCountByAmountRawDto> findLoanByAmount(BankReqDto bankReqDto);
    List<CustomerCountByRegionRawDto> findLoanByRegion(BankReqDto bankReqDto);


}
