package site.doget.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import site.doget.common.CodeMapper;
import site.doget.dto.*;
import site.doget.mybatis.SqlSessionFactoryProvider;
import site.doget.mybatis.mapper.IncomeMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoanCustomerService {

    private static final LoanCustomerService instance = new LoanCustomerService();

    public static LoanCustomerService getInstance() {
        return instance;
    }

    private LoanCustomerService() {
    }

    private final SqlSessionFactory sqlSessionFactory = SqlSessionFactoryProvider.getInstance();

    // 고객 종류별 비교 조회
    public CustTypeCompListResDto findLoanByCustomerType(BankReqDto bankReqDto) {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IncomeMapper incomeMapper = sqlSession.getMapper(IncomeMapper.class);
            List<PlosdocRawDto> plosdocRawDtoList = incomeMapper.findByTermAndBankCode(bankReqDto);


            return new CustTypeCompListResDto(null, null, null);
        }

    }
}
