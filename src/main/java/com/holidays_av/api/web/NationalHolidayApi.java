package com.holidays_av.api.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
public class NationalHolidayApi {

    @Autowired
    private ObjectMapper objectMapper;


    //TODO: this is not good solution, as its very slow. need to rethink
    public boolean isNationalHoliday(LocalDate date) throws IOException, URISyntaxException {

        String stringDate = convertLocalDateToString(date);
        String link = "https://kayaposoft.com/enrico/json/v2.0/?action=isPublicHoliday&date=" + stringDate + "&country=lv";
        URI uri = new URI(link);
        URL url = uri.toURL();

        Map<String, Object> map = objectMapper.readValue(url, Map.class);
        return (boolean) map.get("isPublicHoliday");

    }


    private String convertLocalDateToString(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}

//        https://kayaposoft.com/enrico/json/v2.0/?action=isPublicHoliday&date=05-07-2022&country=lv
