package com.minvoo.iteis.repository;

import com.minvoo.iteis.entity.Computer;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ComputerRepository extends JpaRepository<Computer, Long> {


    @Override
    List<Computer> findAll();
    List<Computer> findAllByEmployee(Employee employee);
    Optional<List<Computer>> findByEmployeeId(Long EmployeeId);
    @Transactional
    void deleteByEmployeeId(Long employeeId);
}
