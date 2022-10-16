package com.minvoo.iteis.service;

import com.minvoo.iteis.entity.Employee;

public interface AuthenticationService {

    Employee signInAndReturnJWT(Employee signInRequest);
    boolean isLoggedUserIsAdmin();
    boolean isUserLogged();
}
