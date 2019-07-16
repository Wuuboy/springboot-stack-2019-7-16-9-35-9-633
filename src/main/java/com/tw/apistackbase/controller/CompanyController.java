package com.tw.apistackbase.controller;

import com.tw.apistackbase.beans.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyController {

    private List<Company>companyList = new ArrayList<>();

    @PostMapping("/companies")
    public ResponseEntity addCompany(@RequestBody Company company){
        company.setCompanyId((long) 1);
        companyList.add(company);
        return ResponseEntity.ok(companyList);
    }

    @GetMapping("/companies")
    public ResponseEntity addEmplyee(){
        return ResponseEntity.ok(companyList);
    }

}
