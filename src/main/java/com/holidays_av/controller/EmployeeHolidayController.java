package com.holidays_av.controller;

import com.holidays_av.dto.HolidayRequestDto;
import com.holidays_av.mapper.EmployeeHolidayRequestMapper;
import com.holidays_av.service.EmployeeHolidayService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/rest/api/EmployeeHoliday.svc")
public class EmployeeHolidayController {

    private final EmployeeHolidayService employeeHolidayService;
    private final EmployeeHolidayRequestMapper employeeHolidayRequestMapper;

    public EmployeeHolidayController(
            EmployeeHolidayService employeeHolidayService,
            EmployeeHolidayRequestMapper employeeHolidayRequestMapper) {
        this.employeeHolidayService = employeeHolidayService;
        this.employeeHolidayRequestMapper = employeeHolidayRequestMapper;
    }

    @PostMapping("/employee_holiday({id})")
    public Integer requestHoliday(@RequestBody HolidayRequestDto holidayRequestDto,
                                  @PathVariable("id") Long id)
            throws IOException, URISyntaxException {
        return employeeHolidayService
                .saveHoliday(id, holidayRequestDto.getStartDate(), holidayRequestDto.getEndDate());
    }
}
