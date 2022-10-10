package com.minvoo.iteis.entity;


import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_Name")
    private String lastName;

    @Column(name="create_time")
    private LocalDateTime createTime;

    @Column(name="position")
    private String position;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @OneToMany(mappedBy = "owner", orphanRemoval = false)
    private Set<Computer> computers = new HashSet<>();


}
