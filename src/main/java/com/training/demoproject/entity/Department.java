package com.training.demoproject.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int departmentId;
    private String name;

    @Column(unique = true)
    private String departmentCode;

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name="parentDepartment",nullable = true)
    private Department parentDepartment;
    //private int parentDepartment;

    @OneToMany(mappedBy = "parentDepartment")
    private Set<Department> childDepartments=new HashSet<Department>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="organizationId",nullable = true)
    private Organization organization;


    @OneToMany(mappedBy = "department",cascade = {CascadeType.ALL})
    private List<Employee> employees;

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public void setParentDepartment(Department parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    public void setChildDepartments(Set<Department> childDepartments) {
        this.childDepartments = childDepartments;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }
}
