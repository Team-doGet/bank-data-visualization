package site.doget.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.data.dto.BankReqDto;
import site.doget.data.dto.raw.PlosdocRawDto;

import java.util.List;

@Mapper
public interface IncomeMapper {

    List<PlosdocRawDto> findByTermAndBankCode(BankReqDto bankReqDto);

}
