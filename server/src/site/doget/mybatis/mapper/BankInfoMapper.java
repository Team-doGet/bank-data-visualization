package site.doget.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.dto.raw.BankInfoRawDto;
import site.doget.dto.raw.PlosdocRawDto;

import java.util.List;

@Mapper
public interface BankInfoMapper {

    List<BankInfoRawDto> findByBankCode(String bankCode);

}
