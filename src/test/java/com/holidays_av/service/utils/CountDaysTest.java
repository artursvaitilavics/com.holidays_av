package com.holidays_av.service.utils;

import com.holidays_av.api.web.NationalHolidayApi;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class CountDaysTest {

    NationalHolidayApi nationalHolidayApi = new NationalHolidayApi();

    @Test
    public void days() throws IOException, URISyntaxException {
        CountDays countDays = new CountDays(nationalHolidayApi);
        LocalDate startDate001 = LocalDate.of(2021, Month.MAY, 4);
        LocalDate endDate001 = LocalDate.of(2021, Month.MAY, 15);

        LocalDate startDate002 = LocalDate.of(2021, Month.JUNE, 1);
        LocalDate endDate002 = LocalDate.of(2021, Month.JUNE, 28);

        LocalDate startDate003 = LocalDate.of(2021, Month.JULY, 1);
        LocalDate endDate003 = LocalDate.of(2021, Month.JULY, 15);

        LocalDate startDate004 = LocalDate.of(2021, Month.NOVEMBER, 1);
        LocalDate endDate004 = LocalDate.of(2021, Month.NOVEMBER, 30);

//      If Bank holiday is on Thursday or Tuesday, then the day between weekend
//        and bank holiday wil also be bank holiday, just some latvian law
//        Fough with failed test a lot, untill realised this. and in
//        official lists, those days are not mentioned as bank holidays, so lots of confusion

        Integer result001 = countDays.days(startDate001, endDate001);
        Integer result002 = countDays.days(startDate002, endDate002);
        Integer result003 = countDays.days(startDate003, endDate003);
        Integer result004 = countDays.days(startDate004, endDate004);

        assertEquals((Integer) 8, result001);
        assertEquals((Integer) 17, result002);
        assertEquals((Integer) 11, result003);
        assertEquals((Integer) 20, result004);
    }
}