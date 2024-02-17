package com.atguigu.test;

import com.atguigu.mapper.CustomerMapper;
import com.atguigu.mapper.OrderMapper;
import com.atguigu.pojo.Customer;
import com.atguigu.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class OrderTest {

    private SqlSession session;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    @Test
    public void testToOne() {
        // 查询订单和对应客户
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Order res = mapper.queryOrderById(1);
        System.out.println(res);
        System.out.println(res.getCustomer());
    }

    @Test
    public void testToMany() {
        CustomerMapper mapper = session.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.queryList();
        System.out.println("customers" + customers);

        for (Customer customer : customers) {
            customer.getOrderList();
        }
    }

    @AfterEach
    public void clean() {
        session.close();
    }

}
