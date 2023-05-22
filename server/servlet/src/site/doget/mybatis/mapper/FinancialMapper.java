package site.doget.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.dto.FinancialReqDto;
import site.doget.dto.raw.FnnrRawDto;

import java.util.List;

@Mapper
public interface FinancialMapper {
    List<FnnrRawDto> findByTermAndBankCode(FinancialReqDto financialReqDto);
}
