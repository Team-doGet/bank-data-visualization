package site.doget.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.dto.BankReqDto;
import site.doget.dto.CustTypeRawDto;

import java.util.List;

@Mapper
public interface LoanCustomerMapper {

    List<CustTypeRawDto> findLoanByCustomerType(BankReqDto bankReqDto);

}
