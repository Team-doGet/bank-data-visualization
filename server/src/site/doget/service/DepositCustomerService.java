package site.doget.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import site.doget.dto.BankReqDto;
import site.doget.dto.CustTypeCompListResDto;
import site.doget.dto.CustTypeCompResDto;
import site.doget.dto.CustTypeRawDto;
import site.doget.mybatis.SqlSessionFactoryProvider;
import site.doget.mybatis.mapper.DepositCustomerMapper;

import java.util.ArrayList;
import java.util.List;

public class DepositCustomerService {

    private static final DepositCustomerService instance = new DepositCustomerService();

    public static DepositCustomerService getInstance() {
        return instance;
    }

    private DepositCustomerService() {
    }

    private final SqlSessionFactory sqlSessionFactory = SqlSessionFactoryProvider.getInstance();

    // 고객 종류별 비교 조회
    public CustTypeCompListResDto findDepositByCustomerType(BankReqDto bankReqDto) {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            DepositCustomerMapper depositCustomerMapper = sqlSession.getMapper(DepositCustomerMapper.class);
            List<CustTypeRawDto> custTypeRawDtoList = depositCustomerMapper.findDepositByCustomerType(bankReqDto);

            // CustTypeCompListResDto
            List<String> dates = new ArrayList<>();
            List<List<String>> data = new ArrayList<>();
            data.add(new ArrayList<>());
            data.add(new ArrayList<>());

            // datasets 추가
            custTypeRawDtoList.forEach(custTypeRawDto -> {
                if (!dates.contains(custTypeRawDto.getNewDt())) {
                    dates.add(custTypeRawDto.getNewDt());
                }
                int dataIndex = "개인".equals(custTypeRawDto.getCustDscdNm()) ? 0 : 1;
                data.get(dataIndex).add(custTypeRawDto.getCount());
            });

            List<CustTypeCompResDto> datasets = new ArrayList<>();
            datasets.add(new CustTypeCompResDto("개인", data.get(0)));
            datasets.add(new CustTypeCompResDto("법인", data.get(1)));
            return new CustTypeCompListResDto(dates, datasets);
        }

    }
}
