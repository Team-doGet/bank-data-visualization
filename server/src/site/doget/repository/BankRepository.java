package site.doget.repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import site.doget.dto.BankDto;

import java.io.Reader;


public class BankRepository {

    private static final SqlSessionFactory sqlSessionFactory = SqlSessionFactoryProvider.getInstance();

    // 싱글톤
    private static final BankRepository instance = new BankRepository();

    public static BankRepository getInstance() {
        return instance;
    }

    private BankRepository() {
    }

    public BankDto findByCode(int code) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("findByCode", code);
    }
}
