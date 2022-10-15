package com.minvoo.iteis.mapper;

import com.minvoo.iteis.dto.PrinterDto;
import com.minvoo.iteis.entity.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrinterMapper {


    public static PrinterDto mapToDTO(Printer printer) {
        return new PrinterDto().toBuilder()
                .id(printer.getId())
                .manufacturer(printer.getManufacturer())
                .model(printer.getModel())
                .employee(printer.getEmployee())
                .build();
    }

    public static List<PrinterDto> mapToDTO(List<Printer> printers) {
        return printers.stream()
                .map(PrinterMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public static Printer mapToEntity(PrinterDto printerDto) {
        return new Printer().setId(printerDto.getId())
                .setManufacturer(printerDto.getManufacturer())
                .setModel(printerDto.getModel())
                .setEmployee(printerDto.getEmployee());
                //.setEmployee(printerDto.getEmployee());
    }
}
