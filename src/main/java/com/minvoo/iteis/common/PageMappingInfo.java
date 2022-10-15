package com.minvoo.iteis.common;

public class PageMappingInfo {

    public static final String LOGIN_PAGE = "login";
    public static final String RESPONSE_403_MAPPING = "/403";
    public static final String RESPONSE_403_VIEW = "/error/403.html";
    public static final String RESPONSE_404_MAPPING = "/404";
    public static final String RESPONSE_404_VIEW = "/error/404.html";
    public static final String ERROR_REQUEST = "/error";
    public static final String AUTHENTICATION_API_PATH = "/api/authentication";
    public static final String EMPLOYEES_API_PATH = "/api/employees";
    public static final String ADMIN_WEB_PATH = "/admin";
    public static final String ADMIN_WEB_ROLE_ID_PATH = "/role/{id}";
    public static final String EMPLOYEES_WEB_PATH = "/employees";
    public static final String ELEMENTS_LIST_WEB_PATH = "/list";
    public static final String ELEMENTS_DELETE_PATH = "/delete/{id}";
    public static final String EMPLOYEE_DELETE_PATH = "/employees/delete/";
    public static final String ELEMENTS_DETAILS_PATH  = "/details/{id}";
    public static final String DETAILS_PATH = "/details";
    public static final String EMPLOYEE_PROFILE_PATH = "/profile";
    public static final String EMPLOYEE_PROFILE_PASSWORD_CHANGE_PATH =
            EMPLOYEE_PROFILE_PATH +"/change-password";
    public static final String EMPLOYEE_DETAILS_CHANGE_PATH = "/employees/details/change/";
    public static final String EMPLOYEE_ADD_PATH = "/employees/employee-add";
    public static final String ALL_ADMIN_PAGES_PATH = "/admin/**";


}
