package com.training.demoproject.services;

import com.training.demoproject.entity.Employee;

import java.util.List;

public interface EmployeeServices {
    Employee save(Employee employee);
    int getCountOfEmployee(int departmentId);
    List<Double> getAverageSalary();
}
