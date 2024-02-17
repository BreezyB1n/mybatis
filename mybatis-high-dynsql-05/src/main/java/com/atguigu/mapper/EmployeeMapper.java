package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    //根据员工姓名和工资查询员工的信息
    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);
}
