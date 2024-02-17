package com.Bin.mapper;

import com.Bin.pojo.Employee;

public interface EmployeeMapper {

    // 根据id查询员工信息
    Employee queryById(Integer id);
}
