package site.doget.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.data.dto.FinancialReqDto;
import site.doget.data.dto.raw.FnnrRawDto;

import java.util.List;

@Mapper
public interface FinancialMapper {
    List<FnnrRawDto> findByTermAndBankCode(FinancialReqDto financialReqDto);
}
