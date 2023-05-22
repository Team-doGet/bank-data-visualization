package site.doget.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.data.dto.raw.BankInfoRawDto;

import java.util.List;

@Mapper
public interface BankInfoMapper {

    List<BankInfoRawDto> findByBankCode(String bankCode);

}
