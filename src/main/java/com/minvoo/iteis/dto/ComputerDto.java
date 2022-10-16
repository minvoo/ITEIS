package com.minvoo.iteis.dto;


import com.minvoo.iteis.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ComputerDto {

    private Long id;
    private String operatingSystem;
    private String processor;
    private String RAM;
    private String disk;
    private String diskCapacity;
    private String osKey;
    private String officeVersion;
    private String officeKey;
    private Employee employee;
}
