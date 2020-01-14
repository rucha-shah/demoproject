package com.training.demoproject.controller;

import com.training.demoproject.dto.OrganizationDTO;
import com.training.demoproject.entity.Employee;
import com.training.demoproject.entity.Organization;
import com.training.demoproject.services.OrganizationServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    OrganizationServices organizationServices;

    @PostMapping(value = "/addOrUpdate")
    public ResponseEntity<Integer> addOrUpdateOrganization(@RequestBody OrganizationDTO organizationDTO)
    {
        Organization organization=new Organization();
        BeanUtils.copyProperties(organizationDTO,organization);
        Organization organizationCreated=organizationServices.save(organization);
        return new ResponseEntity<Integer>(organizationCreated.getOrganizationId(),HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Organization>> getAllOrganization(){
        List<Organization> list=organizationServices.getAllOrganization();
        return new ResponseEntity<List<Organization>>(list,new HttpHeaders(),HttpStatus.OK);
    }




}
