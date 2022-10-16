package com.minvoo.iteis.mapper;

import com.minvoo.iteis.dto.MobileDto;
import com.minvoo.iteis.entity.Mobile;

import java.util.List;
import java.util.stream.Collectors;

public class MobileMapper {


    public static MobileDto mapToDTO(Mobile mobile) {
        return new MobileDto().toBuilder()
                .id(mobile.getId())
                .manufacturer(mobile.getManufacturer())
                .model(mobile.getModel())
                .employee(mobile.getEmployee())
                .build();
    }

    public static List<MobileDto> mapToDTO(List<Mobile> mobiles) {
        return mobiles.stream()
                .map(MobileMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public static Mobile mapToEntity(MobileDto mobileDto) {
        return new Mobile().setId(mobileDto.getId())
                .setManufacturer(mobileDto.getManufacturer())
                .setModel(mobileDto.getModel())
                .setEmployee(mobileDto.getEmployee());
    }
}
