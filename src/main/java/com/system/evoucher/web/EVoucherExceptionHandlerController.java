package com.system.evoucher.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.system.evoucher.exception.InvalidAssignmentException;
import com.system.evoucher.exception.InvalidUserException;

@ControllerAdvice
public class EVoucherExceptionHandlerController {

  @ExceptionHandler(InvalidUserException.class)
  public ModelAndView handleError(HttpServletRequest req, InvalidUserException ex) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("no_access");
    return mav;
  }
  
  @ExceptionHandler(InvalidAssignmentException.class)
  public ModelAndView InvalidAssignmentException(HttpServletRequest req, InvalidAssignmentException ex) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("invalid_assignment");
    return mav;
  }
}