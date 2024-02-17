package com.atguigu.mappers;

import com.atguigu.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    //dml语句
    int deleteById(Integer id);

    //指定输出类型 查询语句
    // 根据员工id查询员工姓名
    String queryNameById(Integer id);
    //根据员工id查询工资
    Double querySalaryById(Integer id);

    Employee queryById(Integer id);

    Map<String, Object> selectEmpNameAndMaxSalary();

    List<String> queryNamesBySalary(double salary);

    List<Employee> selectAll();

    //员工插入
    int insertEmp(Employee employee);
}
