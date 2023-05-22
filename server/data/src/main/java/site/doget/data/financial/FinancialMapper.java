package site.doget.data.financial;

import org.apache.ibatis.annotations.Mapper;
import site.doget.data.financial.dto.FinancialReqDto;
import site.doget.data.financial.dto.FnnrRawDto;

import java.util.List;

@Mapper
public interface FinancialMapper {
    List<FnnrRawDto> findByTermAndBankCode(FinancialReqDto financialReqDto);
}
