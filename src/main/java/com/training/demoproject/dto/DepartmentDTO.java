package com.training.demoproject.dto;

public class DepartmentDTO {
    private int departmentId;
    private String name;
    private String departmentCode;
    private int parentDepartment;
    private int organizationId;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public int getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(int parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }
}
