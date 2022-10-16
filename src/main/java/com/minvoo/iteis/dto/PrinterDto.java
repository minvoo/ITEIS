package com.minvoo.iteis.dto;

import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.entity.Printer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PrinterDto {

    private Long id;
    private String manufacturer;
    private String model;
    private Employee employee;
  }
