package com.holidays_av.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployeeHolidayService {

    private final EmployeeService employeeService;
    private final HolidayService holidayService;

    public EmployeeHolidayService(EmployeeService employeeService, HolidayService holidayService) {
        this.employeeService = employeeService;
        this.holidayService = holidayService;
    }

    public Integer saveHoliday(Integer employeeId, Date startTime, Date endTime) {
//        Calendar calendarStartDate = Calendar.getInstance();
//        calendarStartDate.setTime(startTime);
//
//        Calendar calendarEndDate = Calendar.getInstance();
//        calendarEndDate.setTime(endTime);
//
//        Integer workDays = 0;
//
//        if(calendarStartDate.getTimeInMillis() == calendarEndDate.getTimeInMillis()){
//            return 0;
//        }
//        if (calendarStartDate.getTimeInMillis() > calendarEndDate.getTimeInMillis()){
//
//        }
        return 2;
    }
}
