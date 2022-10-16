package com.minvoo.iteis.dto;

import com.minvoo.iteis.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MobileDto {

    private Long id;
    private String manufacturer;
    private String model;
    private Employee employee;
  }
