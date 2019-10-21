package com.akash.github.springdatajpamysql.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final String DB_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static DateTimeFormatter DB_DATE_FORMATTER = DateTimeFormatter.ofPattern(DB_DATE_FORMAT);

    public static String now() {
        return LocalDateTime.now().format(DB_DATE_FORMATTER);
    }

    public static String millisToDate(Long epochMillis) {
        if(epochMillis != null) {
            LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMillis), ZoneId.systemDefault());
        }
        return null;
    }

    public static Long dateToMillis(String date) {
        try{
            if(!StringUtils.isEmpty(date)) {
                LocalDate localDate = LocalDate.parse(date, DB_DATE_FORMATTER);
                return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
            }
        } catch (Exception ex) {
            //handle exception
        }
        return null;
    }
}
