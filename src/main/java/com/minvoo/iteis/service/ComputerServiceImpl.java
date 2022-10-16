package com.minvoo.iteis.service;

import com.minvoo.iteis.dto.ComputerDto;
import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.dto.MobileDto;
import com.minvoo.iteis.entity.Computer;
import com.minvoo.iteis.entity.Mobile;
import com.minvoo.iteis.exception.ComputerNotFoundException;
import com.minvoo.iteis.mapper.ComputerMapper;
import com.minvoo.iteis.mapper.EmployeeMapper;
import com.minvoo.iteis.mapper.MobileMapper;
import com.minvoo.iteis.repository.ComputerRepository;
import com.minvoo.iteis.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerServiceImpl implements ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    @Override
    public ComputerDto add(ComputerDto computerDto) {
       Computer computer = ComputerMapper.mapToEntity(computerDto);
        Computer savedComputer = computerRepository.saveAndFlush(computer);
        Computer computerResponseEntity = computerRepository.getById(savedComputer.getId());
        return ComputerMapper.mapToDto(computerResponseEntity);
    }

    @Override
    public ComputerDto findById(Long id) {
        return ComputerMapper.mapToDto(computerRepository.findById(id).get());
    }

    @Override
    public Optional<List<Computer>> findByEmployeeId(Long id) {
        return computerRepository.findByEmployeeId(id);
    }

    @Override
    public List<Computer> findAllByEmployee(EmployeeDto employeeDto) {

        return computerRepository.findAllByEmployee(EmployeeMapper.mapToEntity(employeeDto));
    }

    @Override
    public List<ComputerDto> findAll() {
        List<Computer> responseEntity = computerRepository.findAll();
        List<ComputerDto> responseDto = ComputerMapper.mapToDto(responseEntity);
        return responseDto;
    }

    @Override
    public void deleteById(Long id) {
        computerRepository.deleteById(id);
    }
}