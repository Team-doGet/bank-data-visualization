package site.doget.repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryProvider {

    private static final SqlSessionFactory instance;

    static {
        String resource = "site/doget/mybatis/SqlMapConfig.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        instance = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSessionFactory getInstance() {
        return instance;
    }
}
