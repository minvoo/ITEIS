package com.minvoo.iteis.repository;

import com.minvoo.iteis.dto.MobileDto;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.entity.Mobile;
import com.minvoo.iteis.entity.Printer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MobileRepository extends JpaRepository<Mobile,Long> {


    @Override
    List<Mobile> findAll();
    List<Mobile> findAllByEmployee(Employee employee);
    Optional<List<Mobile>> findByEmployeeId(Long EmployeeId);
    @Transactional
    void deleteByEmployeeId(Long employeeId);
}
