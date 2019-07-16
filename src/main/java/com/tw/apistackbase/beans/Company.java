package com.tw.apistackbase.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public class Company {
    private Long companyId;
    private String companyName;
    private List<Employee>employeeList;

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


    public Company(String companyName) {
        this.companyName = companyName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public Company(Long companyId, String companyName, List<Employee> employeeList) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.employeeList = employeeList;
    }

    public Company() {
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }
}
