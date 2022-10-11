package com.minvoo.iteis.repository;

import com.minvoo.iteis.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
