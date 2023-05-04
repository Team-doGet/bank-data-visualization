package site.doget.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.dto.BankReqDto;
import site.doget.dto.raw.CustomerCountByAmountRawDto;
import site.doget.dto.raw.CustomerCountByTypeRawDto;

import java.util.List;

@Mapper
public interface DepositCustomerMapper {

    List<CustomerCountByTypeRawDto> findDepositByCustomerType(BankReqDto bankReqDto);
    List<CustomerCountByAmountRawDto> findDepositByAmount(BankReqDto bankReqDto);
}
