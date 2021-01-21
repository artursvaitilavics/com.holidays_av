package com.holidays_av.service.utils;

import org.threeten.extra.Temporals;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CountDays {

//        Example on input format for the dates!
//        LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
//        LocalDate endDate = LocalDate.of(2021, Month.JANUARY, 31);

    public Integer days(LocalDate startDate, LocalDate endDate) {
        LocalDate localDate = startDate.minusDays(1).with(Temporals.nextWorkingDay());
        Integer countDays = 0;
        Integer counter = 0;

        System.out.println(startDate);
        System.out.println(endDate + "\n");

        while (localDate.isBefore(endDate.plusDays(1))) {
            System.out.println(localDate);

            if (!(localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) || localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) ) {
                countDays++;
            }

            localDate = localDate.plusDays(1);
        }
        return countDays;

    }
}
