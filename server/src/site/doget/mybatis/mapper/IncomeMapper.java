package site.doget.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.dto.IncomeReqDto;
import site.doget.dto.PlosdocRawDto;

import java.util.List;

@Mapper
public interface IncomeMapper {

    List<PlosdocRawDto> findByTermAndBankCode(IncomeReqDto incomeReqDto);

}
