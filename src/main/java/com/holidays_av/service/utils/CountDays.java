package com.holidays_av.service.utils;

import com.holidays_av.web_api.NationalHolidayApi;
import org.threeten.extra.Temporals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class CountDays {
    private NationalHolidayApi nationalHolidayApi = new NationalHolidayApi();


    public Integer days(LocalDate startDate, LocalDate endDate) throws IOException, URISyntaxException {

        LocalDate localDate = startDate.minusDays(1).with(Temporals.nextWorkingDay());
        Integer countDays = 0;


        while (localDate.isBefore(endDate.plusDays(1))) {
            if (!(localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                    || localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)
                    || nationalHolidayApi.isNationalHoliday(localDate)
            )
            ) {
                countDays++;
            }
            localDate = localDate.plusDays(1);
        }


        return countDays;

    }


}
