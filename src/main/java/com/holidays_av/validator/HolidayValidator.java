package com.holidays_av.validator;

import com.holidays_av.model.Holiday;
import com.holidays_av.service.EmployeeService;
import com.holidays_av.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class HolidayValidator {
    private final HolidayService holidayService;
    private final EmployeeService employeeService;


    @Autowired
    public HolidayValidator(HolidayService holidayService,
                            EmployeeService employeeService) {
        this.holidayService = holidayService;
        this.employeeService = employeeService;
    }

    public boolean isValid(Long id, LocalDate startDate, LocalDate endDate) {
        List<Holiday> employeesHolidayList = employeeService
                .findById(id)
                .getHoliday();

        for (Holiday holiday :
                employeesHolidayList) {
            if (holiday.getStartDate().equals(startDate) && holiday.getEndDate().equals(endDate)) {
                return false;
            }
        }
        return true;
    }
}
