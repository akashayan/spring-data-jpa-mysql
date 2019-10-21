package com.akash.github.springdatajpamysql.controllers;

import com.akash.github.springdatajpamysql.db.entities.EmployeeEntity;
import com.akash.github.springdatajpamysql.services.IDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/rest/db")
public class HomeController {

    @Autowired
    IDBService<EmployeeEntity> dbService;

    @GetMapping(value = "/getAllEmployees")
    public Collection<EmployeeEntity> getAllEmployees() {
         return dbService.fetchAll();
    }

    @PostMapping(value = "/insert")
    public EmployeeEntity save(@RequestBody EmployeeEntity employeeEntity) {
        return dbService.save(employeeEntity);
    }
}
