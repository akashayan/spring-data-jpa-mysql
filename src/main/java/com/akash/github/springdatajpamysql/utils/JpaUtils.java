package com.akash.github.springdatajpamysql.utils;

import com.akash.github.springdatajpamysql.models.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

@Converter(autoApply = true)
public class JpaUtils implements AttributeConverter<Address, String> {

    private static ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

    @Override
    public String convertToDatabaseColumn(Address address) {

        try {
            return mapper.writeValueAsString(address);
        } catch (JsonProcessingException ex) {
            // handle exception
            return null;
        }
    }

    @Override
    public Address convertToEntityAttribute(String address) {

        try {
            return mapper.readValue(address, Address.class);
        } catch (IOException ex) {
            // handle exception
            return null;
        }
    }
}
