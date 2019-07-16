package com.tw.apistackbase.controller;

import com.tw.apistackbase.beans.Company;
import com.tw.apistackbase.beans.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyController {

    private List<Company>companyList = new ArrayList<>();
    Employee employee = new Employee((long) 329,"AA","male",23,6000.0);
    Employee employee2 = new Employee((long) 327,"BB","famale",23,12000.0);
    private List<Employee>employeeList = new ArrayList<>();


    @PostMapping("/companies")
    public ResponseEntity addCompany(@RequestBody Company company){
        company.setCompanyId((long) 1);
        companyList.add(company);
        return ResponseEntity.ok(companyList);
    }

    @GetMapping("/companies")
    public ResponseEntity getCompanies(){
        return ResponseEntity.ok(companyList);
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity getCompany(@PathVariable Long id){
     Company company = companyList.stream().filter(c -> c.getCompanyId()==id)
                .findFirst()
                .orElse(null);
        if (company != null) {
            return ResponseEntity.ok(company);
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping("/companies/{id}/employees")
    public ResponseEntity getEmplyeesUnderCertainCompany(@PathVariable Long id){
        Company company = companyList.stream().filter(c -> c.getCompanyId()==id)
                .findFirst()
                .orElse(null);
        employeeList.add(employee);
        employeeList.add(employee2);
        if (company != null) {
            company.setEmployeeList(employeeList);
            return ResponseEntity.ok(company);
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping("/companies?page={page}&pageSize={pageSize}")
    public ResponseEntity getCompaniesWithPage(@PathVariable Integer page,@PathVariable Integer pageSize){
        List<Company>companyListResult = new ArrayList<>();
        for (int i=0;i<pageSize;i++){
            companyListResult.add(companyList.get((page-1)*pageSize+i));
        }
        return ResponseEntity.ok(companyListResult);
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity deleteCompanyById(@PathVariable Long id){
        Company company = companyList.stream().filter(c -> c.getCompanyId()==id)
                .findFirst()
                .orElse(null);
        if (company != null) {
            companyList.remove(company);
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(companyList);
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity updateCompany(@PathVariable Long id,@RequestBody Company company){
        Company findedCompany = companyList.stream().filter(c -> c.getCompanyId()==id)
                .findFirst()
                .orElse(null);
        if (findedCompany != null) {
            BeanUtils.copyProperties(company,findedCompany);
            return ResponseEntity.ok(findedCompany);
        }
        return ResponseEntity.ok(null);
    }

}
