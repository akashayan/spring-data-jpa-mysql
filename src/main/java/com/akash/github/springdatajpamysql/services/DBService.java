package com.akash.github.springdatajpamysql.services;

import com.akash.github.springdatajpamysql.db.entities.EmployeeEntity;
import com.akash.github.springdatajpamysql.db.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DBService implements IDBService<EmployeeEntity> {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public Collection<EmployeeEntity> fetchAll() {
        return employeesRepository.findAll();
    }

    @Override
    public EmployeeEntity fetchById(Long id) {
        return employeesRepository.findById(id).get();
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employee) {
        return employeesRepository.save(employee);
    }

    @Override
    public EmployeeEntity update(EmployeeEntity employee) {
        return employeesRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeesRepository.deleteById(id);
    }
}
