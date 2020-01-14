package com.training.demoproject.services.impl;

import com.training.demoproject.entity.Department;
import com.training.demoproject.repository.DepartmentRepository;
import com.training.demoproject.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServicesImpl implements DepartmentServices {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department)
    {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment()
    {
        List<Department> list = new ArrayList<>();
        for (Department department : departmentRepository.findAll()) {
            list.add(department);
        }
        return list;

    }

    @Override
    public List<Department>getSubDepartment(int departmentId)
    {
        //List<Department> list=new ArrayList<>();
        //Optional<Department> department=departmentRepository.findById(departmentId);
        //getSubDepartment(departmentId);
        //if(department.isPresent())

        //return list;
        List<Department> list=departmentRepository.getSubDepartment(departmentId);
        return list;
    }

}
