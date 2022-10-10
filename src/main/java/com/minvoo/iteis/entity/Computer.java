package com.minvoo.iteis.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name ="computers")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operating_system")
    private String operatingSystem;

    @Column(name = "processor")
    private String processor;

    @Column(name = "ram")
    private String RAM;

    @Column(name = "disk")
    private String disk;

    @Column(name = "disk_capacity")
    private String diskCapacity;

    @Column(name = "os_key")
    private String osKey;

    @Column(name = "office_version")
    private String officeVersion;

    @Column(name = "office_key")
    private String officeKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", nullable = false)
    private Employee employee;
}