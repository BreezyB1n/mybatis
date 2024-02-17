import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class EmployeeTest {
    private SqlSession session;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("com/atguigu/mapper/mybatis-config.xml"))
                .openSession();
    }

    /**
     * 测试if where标签
     */

    @Test
    public void test_01() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.query(null, 101.0);
        System.out.println("list = " + list);

    }

    @AfterEach
    public void clean() {
        session.close();
    }

}
