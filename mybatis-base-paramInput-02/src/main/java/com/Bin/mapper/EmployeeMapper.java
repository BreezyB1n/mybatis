package com.Bin.mapper;

import com.Bin.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    Employee queryById(Integer id);

    //根据id删除员工信息
    int deleteById(Integer id);

    //根据工资查询员工信息
    List<Employee> queryBySalary(double salary);

    //插入员工数据【实体对象】
    int insertEmp(Employee employee);

    //根据员工姓名和工资查询员工信息
    List<Employee> queryByNameAndSalary(@Param("name") String name, @Param("salary") Double salary);

    // 插入员工数据传入一个map
    //记得不要重载
    int insertEmpMap(Map data);

}
