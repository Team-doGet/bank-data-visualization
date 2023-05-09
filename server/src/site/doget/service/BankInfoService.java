package site.doget.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import site.doget.dto.BankInfoResDto;
import site.doget.dto.DateRange;
import site.doget.dto.LoanGuaranteeListResDto;
import site.doget.dto.LoanGuaranteeResDto;
import site.doget.dto.raw.BankInfoRawDto;
import site.doget.dto.raw.LoanInfoRawDto;
import site.doget.mybatis.SqlSessionFactoryProvider;
import site.doget.mybatis.mapper.BankInfoMapper;
import site.doget.mybatis.mapper.LoanInfoMapper;

import java.util.*;

public class BankInfoService {


    private static final BankInfoService instance = new BankInfoService();

    public static BankInfoService getInstance() {
        return instance;
    }

    private BankInfoService() {
    }


    private final SqlSessionFactory sqlSessionFactory = SqlSessionFactoryProvider.getInstance();


    public BankInfoResDto findInfoByBankCode(String bankCode) {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BankInfoMapper bankInfoMapper = sqlSession.getMapper(BankInfoMapper.class);
            List<BankInfoRawDto> bankInfoRawDtoList = bankInfoMapper.findByBankCode(bankCode);

            BankInfoResDto bankInfoResDto = new BankInfoResDto();

            bankInfoResDto.setName(bankInfoRawDtoList.get(0).getName());
            bankInfoRawDtoList.forEach(bankInfoRawDto -> {

                switch (bankInfoRawDto.getInfo()) {
                    case "loanDate":
                        bankInfoResDto.setLoanDate(new DateRange(bankInfoRawDto.getMin(), bankInfoRawDto.getMax()));
                        break;
                    case "depositDate":
                        bankInfoResDto.setDepositDate(new DateRange(bankInfoRawDto.getMin(), bankInfoRawDto.getMax()));
                        break;
                    case "incomeDate":
                        bankInfoResDto.setIncomeDate(new DateRange(bankInfoRawDto.getMin(), bankInfoRawDto.getMax()));
                        break;
                    case "financialDate":
                        bankInfoResDto.setFinancialDate(new DateRange(bankInfoRawDto.getMin(), bankInfoRawDto.getMax()));
                        break;
                }
            });

            return bankInfoResDto;
        }

    }
}
