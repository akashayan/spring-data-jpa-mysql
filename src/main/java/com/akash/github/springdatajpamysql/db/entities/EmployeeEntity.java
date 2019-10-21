package com.akash.github.springdatajpamysql.db.entities;

import com.akash.github.springdatajpamysql.models.Address;
import com.akash.github.springdatajpamysql.utils.JpaUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class EmployeeEntity extends AuditableEntity{

    private String name;

    private String designation;

    @Column(name = "address")
    @Convert(converter = JpaUtils.class)
    private Address address;

    @Column(name = "department_id")
    private Long departmentId;

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;*/
}
