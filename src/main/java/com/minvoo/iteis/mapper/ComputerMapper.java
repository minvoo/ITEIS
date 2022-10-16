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
                .setEmployee(computer.getEmployee())
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
    
    public static Computer mapToEntity(ComputerDto computerDto) {
        return new Computer()
                .setProcessor(computerDto.getProcessor())
                .setRAM(computerDto.getRAM())
                .setOfficeVersion(computerDto.getOfficeVersion())
                .setOfficeKey(computerDto.getOfficeKey())
                .setOsKey(computerDto.getOsKey())
                .setDiskCapacity(computerDto.getDiskCapacity())
                .setDisk(computerDto.getDisk())
                .setEmployee(computerDto.getEmployee())
                .setOperatingSystem(computerDto.getOperatingSystem())
                .setId(computerDto.getId());
    }

    public static List<Computer> mapToEntity(List<ComputerDto> computerDtos) {
        return computerDtos.stream()
                .map(ComputerMapper::mapToEntity)
                .collect(Collectors.toList());
    }
}
