package com.akash.github.springdatajpamysql.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Configuration
public class YamlConfiguration {

    private final Yaml yaml = new Yaml();

    @Bean
    public ConfigurationProperties configurationProperties() throws IOException {

        /*File file = new File(getClass().getClassLoader().getResource("application-config.yaml").getFile());
        FileInputStream fileInputStream = new FileInputStream(file);
        ConfigurationProperties configurationProperties = yaml.loadAs(fileInputStream, ConfigurationProperties.class);
        return configurationProperties;*/

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ConfigurationProperties configurationProperties = objectMapper
                .readValue(new File(getClass().getClassLoader().getResource("application-config.yaml").getFile())
                        , ConfigurationProperties.class);
        return configurationProperties;
    }

}
