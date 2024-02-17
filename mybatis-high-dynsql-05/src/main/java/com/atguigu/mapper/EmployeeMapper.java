package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    //根据员工姓名和工资查询员工的信息
    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);

    // 根据员工id更新员工数据，要求name 和 salary 不为null才更新
    int update(Employee employee);

    List<Employee> queryChoose(@Param("name") String name, @Param("salary") Double salary);

    List<Employee> queryBatch(@Param("ids") List<Integer> ids);

    int deleteBatch(@Param("ids") List<Integer> ids);
    int updateBatch(@Param("list") List<Employee> employeeList);
    int insertBatch(@Param("list") List<Employee> employeeList);




}
