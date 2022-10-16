package com.minvoo.iteis.controller.rest;

import com.minvoo.iteis.dto.MobileDto;
import com.minvoo.iteis.entity.Mobile;
import com.minvoo.iteis.mapper.MobileMapper;
import com.minvoo.iteis.service.MobileService;
import com.minvoo.iteis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mobiles")
public class MobileController {

    @Autowired
    MobileService mobileService;
    @Autowired
    EmployeeService employeeService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    public ResponseEntity<?> getAllMobiles() {
        return new ResponseEntity<>(mobileService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/details/{id}")
    public ResponseEntity<?> getPrinter(@PathVariable Long id) {
        return new ResponseEntity<>(mobileService.findById(id), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping // /api/mobile
    public ResponseEntity<?> saveMobileOrChangeDetails(@RequestBody Mobile mobile) {
        MobileDto mobileDto = MobileMapper.mapToDTO(mobile);
        return new ResponseEntity<>(mobileService.add(mobileDto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMobile(@PathVariable Long id) {
        mobileService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
