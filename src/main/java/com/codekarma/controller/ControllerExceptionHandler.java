package com.codekarma.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.codekarma.exception.InvalidOperationException;

@ControllerAdvice
public class ControllerExceptionHandler {

	//@ResponseStatus( value=HttpStatus.NOT_FOUND, reason="chips::s::s ") // 409
	@ExceptionHandler(InvalidOperationException.class)
	public ModelAndView handleErrorPage(InvalidOperationException exception)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", "Error occurred: " + exception.getFullMessage());
		mav.setViewName("error-main");
		return mav;		
	}
	
	
}
