package site.doget.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.data.dto.BankReqDto;
import site.doget.data.dto.raw.CustomerCountByAmountRawDto;
import site.doget.data.dto.raw.CustomerCountByRegionRawDto;
import site.doget.data.dto.raw.CustomerCountByTypeRawDto;

import java.util.List;

@Mapper
public interface LoanCustomerMapper {

    List<CustomerCountByTypeRawDto> findLoanByCustomerType(BankReqDto bankReqDto);
    List<CustomerCountByAmountRawDto> findLoanByAmount(BankReqDto bankReqDto);
    List<CustomerCountByRegionRawDto> findLoanByRegion(BankReqDto bankReqDto);


}
