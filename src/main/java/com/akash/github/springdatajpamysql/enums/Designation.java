package com.akash.github.springdatajpamysql.enums;

import lombok.Getter;

@Getter
public enum Designation {

    SDE1("SDE1"),
    SDE2("SDE2"),
    LEAD("LEAD"),
    PRINCIPAL_ENGINEER("PRINCIPAL_ENGINEER"),
    TECHNICAL_ARCHITECT("TECHNICAL_ARCHITECT");


    private String value;

    Designation(String value) {
        this.value = value;
    }
}
