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

    /**
     * Adds computer to database
     * @param computerDto - object to add to database
     * @return ComputerDto object saved to database
     */
    @Override
    public ComputerDto add(ComputerDto computerDto) {
       Computer computer = ComputerMapper.mapToEntity(computerDto);
        Computer savedComputer = computerRepository.saveAndFlush(computer);
        Computer computerResponseEntity = computerRepository.getById(savedComputer.getId());
        return ComputerMapper.mapToDto(computerResponseEntity);
    }


    /**
     * Finds entity in database by id
     * @param id - primary key value of entity
     * @return ComputerDto object
     */
    @Override
    public ComputerDto findById(Long id) {
        return ComputerMapper.mapToDto(computerRepository.findById(id).get());
    }


    /**
     * Finds entity in database by Employee ID.<br>
     * Returns Optional in case of getting null from database.
     * @param id - primary key value of Employee Entity
     * @return Optional<List<Computer>
     */
    @Override
    public Optional<List<Computer>> findByEmployeeId(Long id) {
        return computerRepository.findByEmployeeId(id);
    }

    /**
     * Finds entity in database by Employee entity<br>
     * @param employeeDto - EmployeeDto converted from Entity using Mapper object
     * @return List<Computer>
     */
    @Override
    public List<Computer> findAllByEmployee(EmployeeDto employeeDto) {

        return computerRepository.findAllByEmployee(EmployeeMapper.mapToEntity(employeeDto));
    }

    /**
     * Finds all computers (as DTO objects) in the database
     * @return List<ComputerDto>
     */
    @Override
    public List<ComputerDto> findAll() {
        List<Computer> responseEntity = computerRepository.findAll();
        List<ComputerDto> responseDto = ComputerMapper.mapToDto(responseEntity);
        return responseDto;
    }

    /**
     * Deletes entity by id
     * @param id - id on entity to delete
     * @returns void
     */
    @Override
    public void deleteById(Long id) {
        computerRepository.deleteById(id);
    }
}