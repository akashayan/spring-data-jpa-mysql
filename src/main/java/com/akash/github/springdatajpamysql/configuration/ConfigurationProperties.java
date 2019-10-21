package com.akash.github.springdatajpamysql.configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigurationProperties {

    private DatabaseConfiguration databaseConfiguration;

    @Getter
    @Setter
    public static class DatabaseConfiguration {

        private String endpoint;

        private String userName;

        private String password;

        private String driverClassName;

        private Hibernate hibernate;
    }

    @Getter
    @Setter
    public static class Hibernate {

        private String ddlAuto;

        private String dialect;

        private String showSql;
    }
}
