package com.holidays_av.mapper;

import com.holidays_av.service.EmployeeHolidayService;
import org.springframework.stereotype.Component;


@Component
public class EmployeeHolidayRequestMapper {

    private final EmployeeHolidayService employeeHolidayService;


    public EmployeeHolidayRequestMapper(
            EmployeeHolidayService employeeHolidayService) {
        this.employeeHolidayService = employeeHolidayService;
    }


//    public HolidayRequestDto toDto(Employee employee, Holiday holiday) {
//        HolidayRequestDto holidayRequestDto = new HolidayRequestDto();
//
//        holidayRequestDto.setId(employee.getId());
//        holidayRequestDto.setStartDate(holiday.getStartDate());
//        holidayRequestDto.setEndDate(holiday.getEndDate());
//        holidayRequestDto
//                .setDaysTaken(employeeHolidayService.saveHoliday(employee.getId(),
//                        holiday.getStartDate(),
//                        holiday.getEndDate()));
//
//        return holidayRequestDto;
//    }


}
