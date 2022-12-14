package com.minvoo.iteis.controller.rest;

import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.service.AuthenticationService;
import com.minvoo.iteis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.minvoo.iteis.common.PageMappingInfo.AUTHENTICATION_API_PATH;

@RestController
@RequestMapping(AUTHENTICATION_API_PATH)//pre-path
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("sign-up")//api/authentication/sign-up
    public ResponseEntity<?> signUp(@RequestBody Employee employee) {

        if (employeeService.findByUsername(employee.getUsername()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PostMapping("sign-in")//api/authentication/sign-in
    public ResponseEntity<?> signIn(@RequestBody Employee employee) {
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(employee), HttpStatus.OK);
    }
}