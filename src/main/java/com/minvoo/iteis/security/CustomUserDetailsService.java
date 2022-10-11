package com.minvoo.iteis.security;

import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.service.EmployeeService;
import com.minvoo.iteis.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(employee.getRole().name()));

        //UserDetails
        return UserPrinciple.builder()
                .employee(employee)
                .id(employee.getId())
                .username(employee.getUsername())
                .password(employee.getPassword())
                .authorities(authorities)
                .build();
    }
}
