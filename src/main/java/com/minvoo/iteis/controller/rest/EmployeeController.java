package com.minvoo.iteis.controller.rest;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.security.UserPrinciple;
import com.minvoo.iteis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.minvoo.iteis.common.PageMappingInfo.EMPLOYEES_API_PATH;

@RestController
@RequestMapping(EMPLOYEES_API_PATH)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/list")
    public ResponseEntity<?> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("/details/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }
    @PostMapping // /api/employee
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    @PutMapping("details/change/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id,
                                            @RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeResponse = employeeService.updateEmployee(employeeDto, id);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id,
                                            Authentication authentication) {
        employeeService.deleteById(id, authentication);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
