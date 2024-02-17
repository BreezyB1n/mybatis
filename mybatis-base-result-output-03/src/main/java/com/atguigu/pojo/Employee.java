package com.atguigu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Alias("employee")
public class Employee {
    private Integer empId;
    private String empName;
    private Double empSalary;
}
