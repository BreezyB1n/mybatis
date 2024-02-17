import com.atguigu.mappers.EmployeeMapper;
import com.atguigu.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;



public class ATest {
    private SqlSession sqlSession;

    @BeforeEach
    public void before() throws IOException {
        // 1.读取外部配置文件 (mybatis-config.xml)
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        //2. 创建sqlSessionFactory
        SqlSessionFactory sqlSessionFac = new SqlSessionFactoryBuilder().build(ips);
        //3. 根据sqlSessionFactory创建sqlSession(每次业务创建一个，用完就释放)
        sqlSession = sqlSessionFac.openSession();
    }

    @Test
    public void testQueryEmpNameAndSalary() throws IOException {
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Map<String, Object> resultMap = employeeMapper.selectEmpNameAndMaxSalary();

        Set<Map.Entry<String, Object>> entrySet = resultMap.entrySet();

        for (Map.Entry<String, Object> entry : entrySet) {

            String key = entry.getKey();

            Object value = entry.getValue();

            System.out.println(key + " " + value);

        }
    }

    @Test
    public void test_01() throws IOException {
        // 1.读取外部配置文件 (mybatis-config.xml)
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        //2. 创建sqlSessionFactory
        SqlSessionFactory sqlSessionFac = new SqlSessionFactoryBuilder().build(ips);
        //3. 根据sqlSessionFactory创建sqlSession(每次业务创建一个，用完就释放)
        SqlSession sqlSession = sqlSessionFac.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setEmpName("BIn");
        employee.setEmpSalary(8880.0);

        int res = mapper.insertEmp(employee);
        System.out.println(res);

        //释放资源 提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
