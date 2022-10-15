package com.minvoo.iteis.repository;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.entity.Printer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PrinterRepository extends JpaRepository<Printer,Long> {


    @Override
    List<Printer> findAll();

    List<Printer> findAllByEmployee(Employee employee);

    Optional<List<Printer>> findByEmployeeId(Long EmployeeId);
    @Transactional
    void deleteByEmployeeId(Long employeeId);
}
