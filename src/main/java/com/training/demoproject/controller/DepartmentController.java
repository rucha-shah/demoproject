package com.training.demoproject.controller;

import com.training.demoproject.dto.DepartmentDTO;
import com.training.demoproject.entity.Department;
import com.training.demoproject.services.DepartmentServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentServices departmentServices;

    @PostMapping(value = "/addOrUpdate")
    public ResponseEntity<Integer> addOrUpdateDepartment(@RequestBody DepartmentDTO departmentDTO) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentDTO, department);
        Department departmentCreated = departmentServices.save(department);
        return new ResponseEntity<Integer>(departmentCreated.getDepartmentId(), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Department>> getAllDepartment() {
        List<Department> list = departmentServices.getAllDepartment();
        return new ResponseEntity<List<Department>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getAll/{departmentId}")
    public ResponseEntity<List<Department>> getSubDepartment(@PathVariable int departmentId) {
        List<Department> list = departmentServices.getSubDepartment(departmentId);
        return new ResponseEntity<List<Department>>(list, HttpStatus.OK);
    }
}

