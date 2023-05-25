package site.doget.data.deposit;

import org.apache.ibatis.annotations.Mapper;
import site.doget.data.common.dto.BankReqDto;
import site.doget.data.common.dto.CustomerCountByAmountRawDto;
import site.doget.data.common.dto.CustomerCountByRegionRawDto;
import site.doget.data.common.dto.CustomerCountByTypeRawDto;

import java.util.List;

@Mapper
public interface DepositCustomerMapper {

    List<CustomerCountByTypeRawDto> findDepositByCustomerType(BankReqDto bankReqDto);
    List<CustomerCountByAmountRawDto> findDepositByAmount(BankReqDto bankReqDto);
    List<CustomerCountByRegionRawDto> findDepositByRegion(BankReqDto bankReqDto);
}
