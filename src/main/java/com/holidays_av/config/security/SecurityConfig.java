package com.holidays_av.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

//public class SecurityConfig{}

public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {


        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("adminPass"))
                .roles("ADMIN");
        auth.inMemoryAuthentication()
                .withUser("employee").password(passwordEncoder().encode("empPass"))
                .roles("EMPLOYEE");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/rest/api/Company.svc/**").hasRole("ADMIN")
                .antMatchers("/rest/api/CurrentCompany.svc/**").hasAnyRole("ADMIN")
                .antMatchers("/rest/api/EmployeeHoliday.svc/**").hasAnyRole("ADMIN",  "EMPLOYEE")
                .antMatchers("/rest/api/Employee.svc/**").hasAnyRole("EMPLOYEE", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin();

    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}



