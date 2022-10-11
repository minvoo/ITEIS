package com.minvoo.iteis.service;

import com.minvoo.iteis.dto.ComputerDto;
import com.minvoo.iteis.entity.Computer;
import com.minvoo.iteis.exception.ComputerNotFoundException;
import com.minvoo.iteis.mapper.ComputerMapper;
import com.minvoo.iteis.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {

    @Autowired
    ComputerRepository computerRepository;

    @Override
    public List<ComputerDto> getAllComputers() {
        List<Computer> computers = computerRepository.findAll();
        return ComputerMapper.mapToDto(computers);

    }

    @Override
    public ComputerDto findById(Long id) {

        Computer computer = computerRepository.findById(id)
                .orElseThrow(() -> new ComputerNotFoundException("Computer not found.")
                );

        return ComputerMapper.mapToDto(computer);
    }

    @Override
    public Computer saveComputer(Computer computer, Long employeeId) {

        computer.setEmployeeId(employeeId);
        return computerRepository.saveAndFlush(computer);
    }

    @Override
    public void deleteById(Long id) {

        computerRepository.deleteById(id);

    }

    @Override
    public ComputerDto updateComputer(ComputerDto computerDto, Long id) {


        Computer computer = computerRepository.getById(id);
        computer.setDisk(computerDto.getDisk())
                .setDiskCapacity(computerDto.getDiskCapacity())
                .setRAM(computerDto.getRAM())
                .setOfficeVersion(computerDto.getOfficeVersion())
                .setOfficeKey(computerDto.getOfficeKey())
                .setOsKey(computerDto.getOsKey())
                .setOperatingSystem(computerDto.getOperatingSystem())
                .setProcessor(computerDto.getProcessor());

        computerRepository.saveAndFlush(computer);
        return ComputerMapper.mapToDto(computer);
    }
}
