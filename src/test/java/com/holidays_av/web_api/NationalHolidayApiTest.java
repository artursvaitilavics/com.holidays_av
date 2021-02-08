package com.holidays_av.web_api;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NationalHolidayApiTest {

    private NationalHolidayApi nationalHolidayApi = new NationalHolidayApi();


    @Test
    public void isNationalHoliday() throws IOException, URISyntaxException {
        LocalDate date01 = LocalDate.of(2021, Month.JANUARY, 1);
        LocalDate date02 = LocalDate.of(2021, Month.MAY, 4);
        LocalDate date03 = LocalDate.of(2022, Month.MAY, 6);
        LocalDate date04 = LocalDate.of(2022, Month.JUNE, 23);
        LocalDate date05 = LocalDate.of(2022, Month.AUGUST, 1);

        boolean result001 = nationalHolidayApi.isNationalHoliday(date01);
        boolean result002 = nationalHolidayApi.isNationalHoliday(date02);
        boolean result003 = nationalHolidayApi.isNationalHoliday(date03);
        boolean result004 = nationalHolidayApi.isNationalHoliday(date04);
        boolean result005 = nationalHolidayApi.isNationalHoliday(date05);


        assertTrue(result001);
        assertTrue(result002);
        assertFalse(result003);
        assertTrue(result004);
        assertFalse(result005);

    }

}
