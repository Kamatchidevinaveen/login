package com.someco.helloworld.controller;

import javax.servlet.http.HttpServletRequest;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
	    System.out.println("Request: " + req.getRequestURL() + " raised " + ex.getMessage());
	    
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		ex.printStackTrace();
	    return mav;
	}
}
