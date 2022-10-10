package com.minvoo.iteis.dto;

import com.minvoo.iteis.entity.Computer;
import com.minvoo.iteis.entity.Role;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {


    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime createTime;
    private String position;
    private Role role;
    private Set<Computer> computers = new HashSet<>();
}
