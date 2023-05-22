package site.doget.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.data.dto.BankReqDto;
import site.doget.data.dto.raw.CustomerCountByAmountRawDto;
import site.doget.data.dto.raw.CustomerCountByRegionRawDto;
import site.doget.data.dto.raw.CustomerCountByTypeRawDto;

import java.util.List;

@Mapper
public interface DepositCustomerMapper {

    List<CustomerCountByTypeRawDto> findDepositByCustomerType(BankReqDto bankReqDto);
    List<CustomerCountByAmountRawDto> findDepositByAmount(BankReqDto bankReqDto);
    List<CustomerCountByRegionRawDto> findDepositByRegion(BankReqDto bankReqDto);
}
