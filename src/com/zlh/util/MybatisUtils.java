package com.zlh.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory1;

    public MybatisUtils() {
    }

    public static SqlSession getSqlSession(boolean flag) {
        return sqlSessionFactory1.openSession(flag);
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        if (null != sqlSession) {
            sqlSession.close();
        }

    }

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory1 = (new SqlSessionFactoryBuilder()).build(reader);
        } catch (IOException var1) {
            var1.printStackTrace();
        }

    }
}
