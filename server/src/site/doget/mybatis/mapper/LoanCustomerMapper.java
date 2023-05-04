package site.doget.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.dto.BankReqDto;
import site.doget.dto.CustomerCountByTypeRawDto;
import site.doget.dto.CustomerCountByAmountRawDto;

import java.util.List;

@Mapper
public interface LoanCustomerMapper {

    List<CustomerCountByTypeRawDto> findLoanByCustomerType(BankReqDto bankReqDto);
    List<CustomerCountByAmountRawDto> findLoanByAmount(BankReqDto bankReqDto);


}