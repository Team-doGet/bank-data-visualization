package site.doget.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.dto.BankReqDto;
import site.doget.dto.PlosdocRawDto;

import java.util.List;

@Mapper
public interface IncomeMapper {

    List<PlosdocRawDto> findByTermAndBankCode(BankReqDto bankReqDto);

}
