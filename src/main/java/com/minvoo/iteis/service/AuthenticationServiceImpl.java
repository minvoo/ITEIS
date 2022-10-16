package com.minvoo.iteis.service;

import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.entity.Role;
import com.minvoo.iteis.security.UserPrinciple;
import com.minvoo.iteis.security.jwt.JwtProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public Employee signInAndReturnJWT(Employee signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrinciple);

        Employee signInUser = userPrinciple.getEmployee();
        signInUser.setToken(jwt);

        return signInUser;
    }

    /**
     * Checks if current User has ADMIN role.
     * @return "true" if user has Admin role, "false" if user has other role.
     */
    @Override
    public boolean isLoggedUserIsAdmin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = auth.getName();
        Optional<Employee> currentUserEntityOptional = employeeService.findByUsername(currentUserName);
        if (currentUserEntityOptional.isPresent()) {
            Employee currentUserEntity = currentUserEntityOptional.get();
            if (currentUserEntity.getRole().equals(Role.ADMIN)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Checks if client is logged in.
     * @return "true" if client is logged in, "false" if client is not logged in
     */
        @Override
        public boolean isUserLogged () {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return authentication != null && !(authentication instanceof AnonymousAuthenticationToken);
        }
    }
