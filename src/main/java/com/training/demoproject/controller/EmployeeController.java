package com.training.demoproject.controller;

import com.training.demoproject.dto.EmployeeDTO;
import com.training.demoproject.entity.Employee;
import com.training.demoproject.services.EmployeeServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeServices employeeServices;
    @PostMapping(value = "/addOrUpdate")
    public ResponseEntity<Integer> addOrUpdateEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        Employee employeeCreated=employeeServices.save(employee);
        return new ResponseEntity<Integer>(employeeCreated.getEmployeeId(),HttpStatus.CREATED);
    }

    @GetMapping("/getCount/{departmentId}")
    public ResponseEntity<Integer> getCountOfEmployee(@PathVariable int departmentId)
    {
        //Employee employee=new Employee();
        return new ResponseEntity<Integer>(employeeServices.getCountOfEmployee(departmentId),HttpStatus.OK);
    }

    @GetMapping("/getAverageSalary")
    public ResponseEntity<List<Double>> getAverageSalary()
    {
        List<Double>list=employeeServices.getAverageSalary();
        return new ResponseEntity<List<Double>>(list,HttpStatus.OK);
    }

}
