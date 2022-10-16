package com.minvoo.iteis.service;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.dto.MobileDto;
import com.minvoo.iteis.dto.PrinterDto;
import com.minvoo.iteis.entity.Mobile;
import com.minvoo.iteis.entity.Printer;

import java.util.List;
import java.util.Optional;

public interface MobileService {

    MobileDto add(MobileDto mobileDto);
    MobileDto findById(Long id);

    Optional<List<Mobile>> findByEmployeeId(Long id);

    List<Mobile> findAllByEmployee(EmployeeDto employeeDto);

    List<MobileDto> findAll();

    void deleteById(Long id);

}
