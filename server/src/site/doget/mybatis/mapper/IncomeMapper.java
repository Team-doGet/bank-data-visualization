package site.doget.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.doget.dto.PlosdocDto;

import java.util.List;
import java.util.Map;

@Mapper
public interface IncomeMapper {

    List<PlosdocDto> findByTermAndBankCode(Map<String, String> paramMap);

}
