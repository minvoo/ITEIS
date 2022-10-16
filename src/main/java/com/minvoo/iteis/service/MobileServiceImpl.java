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

    /**
     * Adds mobile to database
     * @param mobileDto - object to add to database
     * @return MobileDto object saved to database
     */
    @Override
    public MobileDto add(MobileDto mobileDto) {
        Mobile mobile = MobileMapper.mapToEntity(mobileDto);
        Mobile savedMobile = mobileRepository.saveAndFlush(mobile);
        Mobile mobileResponseEntity = mobileRepository.getById(savedMobile.getId());
        return MobileMapper.mapToDTO(mobileResponseEntity);
    }

    /**
     * Finds entity in database by id
     * @param id - primary key value of entity
     * @return MobileDto object
     */
    @Override
    public MobileDto findById(Long id) {
        return MobileMapper.mapToDTO(mobileRepository.findById(id).get());
    }

    /**
     * Finds entity in database by Employee ID.<br>
     * Returns Optional in case of getting null from database.
     * @param id - primary key value of Employee Entity
     * @return Optional<List<Mobile>
     */
    @Override
    public Optional<List<Mobile>> findByEmployeeId(Long id) {
        return mobileRepository.findByEmployeeId(id);
    }

    /**
     * Finds entity in database by Employee entity<br>
     * @param employeeDto - EmployeeDto converted from Entity using Mapper object
     * @return List<Mobile>
     */
    @Override
    public List<Mobile> findAllByEmployee(EmployeeDto employeeDto) {

        return mobileRepository.findAllByEmployee(EmployeeMapper.mapToEntity(employeeDto));
    }

    /**
     * Finds all mobiles (as DTO objects) in the database
     * @return List<MobileDto>
     */
    @Override
    public List<MobileDto> findAll() {
        List<Mobile> responseEntity = mobileRepository.findAll();
        List<MobileDto> responseDto = MobileMapper.mapToDTO(responseEntity);
        return responseDto;
    }
    
    /**
     * Deletes entity by id
     * @param id - id on entity to delete
     * @returns void
     */
    @Override
    public void deleteById(Long id) {
        mobileRepository.deleteById(id);
    }
}
