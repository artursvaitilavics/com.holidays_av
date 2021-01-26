package com.holidays_av.controller;

import com.holidays_av.dto.CompanyDto;
import com.holidays_av.mapper.CompanyMapper;
import com.holidays_av.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/api/Company.svc")
public class CompanyController {

    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyController(
            CompanyService companyService,
            CompanyMapper companyMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/test")
    public String getTest() {
        return "test";
    }

    @RolesAllowed("ADMIN")
    @RequestMapping(value = "/test({name})", produces = "application/json", method = {RequestMethod.POST})
    public String setTest(@PathVariable("name") String name) {
        return "test " + name;
    }

    @RolesAllowed("ADMIN")
    @RequestMapping(value = "/companySave", produces = "application/json", method = {RequestMethod.POST})
    public CompanyDto save(@RequestBody CompanyDto companyDto) {
        return companyMapper
                .toDto(companyService
                        .save(companyMapper.fromDto(companyDto)));
    }

    @GetMapping("/companies")
    public List<CompanyDto> getAllCompanies() {
        List<CompanyDto> companyDtoList = new ArrayList<>();
        return companyService.findAll().stream()
                .map(companyMapper::toDto).collect(Collectors.toList());
    }


    @PutMapping("/company({id})")
    public CompanyDto update(@PathVariable("id") Long id,
                             @RequestBody CompanyDto companyDto) {
        return companyMapper
                .toDto(companyService
                        .update(companyMapper.fromDto(companyDto), id));
    }

    @DeleteMapping("/company({id})")
    public CompanyDto delete(@PathVariable Long id) {
        return companyMapper.toDto(companyService.delete(id));
    }


}
