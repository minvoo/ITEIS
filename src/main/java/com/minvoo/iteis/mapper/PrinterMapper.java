package com.minvoo.iteis.mapper;

import com.minvoo.iteis.dto.PrinterDto;
import com.minvoo.iteis.entity.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrinterMapper {


    /**
     * Converts entity to dto object
     * @param printers - list of entity objects
     * @return List<ComputerDto>
     */
    public static PrinterDto mapToDTO(Printer printer) {
        return new PrinterDto().toBuilder()
                .id(printer.getId())
                .manufacturer(printer.getManufacturer())
                .model(printer.getModel())
                .employee(printer.getEmployee())
                .build();
    }
    
    /**
     * Converts dto to entity object
     * @param printerDto - dto to convert into entity
     * @return Computer
     */

    public static List<PrinterDto> mapToDTO(List<Printer> printers) {
        return printers.stream()
                .map(PrinterMapper::mapToDTO)
                .collect(Collectors.toList());
    }


    /**
     * Converts dtos to entity objects
     * @param printerDtos - list of dtos to convert into entity objects
     * @return List<Computer>
     */
    public static Printer mapToEntity(PrinterDto printerDto) {
        return new Printer().setId(printerDto.getId())
                .setManufacturer(printerDto.getManufacturer())
                .setModel(printerDto.getModel())
                .setEmployee(printerDto.getEmployee());
          
    }
}
