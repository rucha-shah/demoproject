package com.training.demoproject.services.impl;

import com.training.demoproject.entity.Department;
import com.training.demoproject.entity.Employee;
import com.training.demoproject.repository.DepartmentRepository;
import com.training.demoproject.repository.EmployeeRepository;
import com.training.demoproject.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;
    //@Autowired
    //DepartmentRepository departmentRepository;


    @Override
    public Employee save(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @Override
    public int getCountOfEmployee(int departmentId)
    {

        return employeeRepository.getCountOfEmployee(departmentId);
    }

    @Override
    public List<Double> getAverageSalary()
    {
        List<Double> list=employeeRepository.getAverageSalary();
        return list;
    }
}
