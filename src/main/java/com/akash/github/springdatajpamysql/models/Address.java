package com.akash.github.springdatajpamysql.models;

import lombok.Data;

@Data
public class Address {

    private String houseNo;

    private String locality;

    private String city;

    private String state;

    private Long pinCode;
}
