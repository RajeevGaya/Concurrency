package com.rajeev.docker_mysql.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmployeeController {
    
    @Autowired
    private EmpRepoistory empRepoistory;
   
    @GetMapping()
    public List<Emp> getEmps(){
         return (List<Emp>) empRepoistory.findAll();
        // return null;
    }

    @GetMapping("/save")
    public Iterable<Emp> postMethodName() {
        List<Emp> list = new ArrayList<>();
        Emp emp = new Emp();
        emp.setAge(23);
        emp.setName("rajeev");
        emp.setSal(2400);
        list.add(emp);

        emp = new Emp();
        emp.setAge(32);
        emp.setName("ranjan");
        emp.setSal(2700);
        list.add(emp);

        return empRepoistory.saveAll(list);
    }
    
}
