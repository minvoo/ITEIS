package com.minvoo.iteis.dto;

import com.minvoo.iteis.entity.Printer;
import com.minvoo.iteis.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {


    private Long id;
    private String uuid;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDateTime createTime;
    private String position;
    private Role role;
    //  private Set<Computer> computers = new HashSet<>();
}
