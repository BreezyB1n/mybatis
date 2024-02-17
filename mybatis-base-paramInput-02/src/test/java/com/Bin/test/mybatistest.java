package com.Bin.test;

import com.Bin.mapper.EmployeeMapper;
import com.Bin.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class mybatistest {
    @Test
    public void test_01() throws IOException {
        //读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
        // 获取sqlSession对象 【自动开启】
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = mapper.queryById(1);

        System.out.println(employee);

        sqlSession.commit();
        sqlSession.close();
    }
}
