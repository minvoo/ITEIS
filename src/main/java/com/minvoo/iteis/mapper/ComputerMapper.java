package com.minvoo.iteis.mapper;

import com.minvoo.iteis.dto.ComputerDto;
import com.minvoo.iteis.entity.Computer;

import java.util.List;
import java.util.stream.Collectors;

public class ComputerMapper {

    public static ComputerDto mapToDto(Computer computer) {

        return new ComputerDto()
                .setDisk(computer.getDisk())
                .setId(computer.getId())
                .setDiskCapacity(computer.getDiskCapacity())
                .setIsLaptop(computer.getIsLaptop())
                .setEmployee(computer.getEmployee())
                .setEmployeeId(computer.getEmployeeId())
                .setOfficeKey(computer.getOfficeKey())
                .setRAM(computer.getRAM())
                .setProcessor(computer.getProcessor())
                .setOsKey(computer.getOsKey())
                .setOfficeVersion(computer.getOfficeVersion())
                .setOperatingSystem(computer.getOperatingSystem());
    }

    public static List<ComputerDto> mapToDto(List<Computer> computers) {

        return computers.stream()
                .map(ComputerMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
