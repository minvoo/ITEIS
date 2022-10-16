package com.minvoo.iteis.service;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.dto.MobileDto;
import com.minvoo.iteis.entity.Mobile;
import com.minvoo.iteis.entity.Printer;
import com.minvoo.iteis.mapper.EmployeeMapper;
import com.minvoo.iteis.mapper.MobileMapper;
import com.minvoo.iteis.mapper.PrinterMapper;
import com.minvoo.iteis.repository.MobileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MobileServiceImpl implements MobileService {

    @Autowired
    private MobileRepository mobileRepository;

    @Override
    public MobileDto add(MobileDto mobileDto) {
        Mobile mobile = MobileMapper.mapToEntity(mobileDto);
        Mobile savedMobile = mobileRepository.saveAndFlush(mobile);
        Mobile mobileResponseEntity = mobileRepository.getById(savedMobile.getId());
        return MobileMapper.mapToDTO(mobileResponseEntity);
    }

    @Override
    public MobileDto findById(Long id) {
        return MobileMapper.mapToDTO(mobileRepository.findById(id).get());
    }

    @Override
    public Optional<List<Mobile>> findByEmployeeId(Long id) {
        return mobileRepository.findByEmployeeId(id);
    }

    @Override
    public List<Mobile> findAllByEmployee(EmployeeDto employeeDto) {

        return mobileRepository.findAllByEmployee(EmployeeMapper.mapToEntity(employeeDto));
    }

    @Override
    public List<MobileDto> findAll() {
        List<Mobile> responseEntity = mobileRepository.findAll();
        List<MobileDto> responseDto = MobileMapper.mapToDTO(responseEntity);
        return responseDto;
    }

    @Override
    public void deleteById(Long id) {
        mobileRepository.deleteById(id);
    }
}
