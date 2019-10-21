package com.akash.github.springdatajpamysql.db.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
public class DepartmentEntity extends AuditableEntity{

    private String name;

    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "department", cascade = CascadeType.ALL)
    private List<EmployeeEntity> employees;*/
}
