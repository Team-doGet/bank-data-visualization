package site.doget.data.bank;

import org.apache.ibatis.annotations.Mapper;
import site.doget.data.bank.dto.BankInfoRawDto;

import java.util.List;

@Mapper
public interface BankInfoMapper {

    List<BankInfoRawDto> findByBankCode(String bankCode);

}
