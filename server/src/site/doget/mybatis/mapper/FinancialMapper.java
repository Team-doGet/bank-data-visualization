package site.doget.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.dto.FinancialReqDto;
import site.doget.dto.FnnrRawDto;

import java.util.List;
import java.util.Map;

@Mapper
public interface FinancialMapper {
    List<FnnrRawDto> findByTermAndBankCode(FinancialReqDto financialReqDto);
}
