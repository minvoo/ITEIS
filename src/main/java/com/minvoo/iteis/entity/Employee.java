package com.minvoo.iteis.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})})
@Accessors(chain = true, fluent = false)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "username", nullable = false)
    @NonNull
    private String username;

    @Column(name = "password", nullable = false)
    @NonNull
    @Size(min = 8, message = "Password must have at least 8 characters")
    private String password;

    @Column(name = "email", nullable = false)
    @NonNull
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "position")
    private String position;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Transient
    private String token;

//    @JsonIgnoreProperties
//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = false)
//    private Set<Computer> computers = new HashSet<>();


}
