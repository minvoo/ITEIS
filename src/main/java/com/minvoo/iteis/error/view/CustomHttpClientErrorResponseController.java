package com.minvoo.iteis.error.view;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import static com.minvoo.iteis.common.PageMappingInfo.*;


@Controller
public class CustomHttpClientErrorResponseController implements ErrorController {
    @RequestMapping(ERROR_REQUEST)
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return RESPONSE_404_VIEW;
            }
            else if(statusCode == HttpStatus.FORBIDDEN.value()) {
                return RESPONSE_403_VIEW;
            }
        }
        return "error";
    }
}
