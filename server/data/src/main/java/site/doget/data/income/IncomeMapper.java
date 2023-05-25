package site.doget.data.income;

import org.apache.ibatis.annotations.Mapper;
import site.doget.data.common.dto.BankReqDto;
import site.doget.data.income.dto.PlosdocRawDto;

import java.util.List;

@Mapper
public interface IncomeMapper {

    List<PlosdocRawDto> findByTermAndBankCode(BankReqDto bankReqDto);

}
