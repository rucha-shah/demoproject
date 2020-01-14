package com.training.demoproject.services;

import com.training.demoproject.entity.Department;

import java.util.List;

public interface DepartmentServices {
    Department save(Department department);
    List<Department> getAllDepartment();
    List<Department> getSubDepartment(int departmentId);
}
