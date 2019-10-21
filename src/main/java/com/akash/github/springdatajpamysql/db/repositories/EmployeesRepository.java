package com.akash.github.springdatajpamysql.db.repositories;

import com.akash.github.springdatajpamysql.db.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeeEntity, Long> {
}
