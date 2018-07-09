package com.george.booking.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	//Page exception handler
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is not constructed!");
		
		mv.addObject("errorDescription", "The page you are looking for is not available now!");
		
		mv.addObject("title", "404 Error Page");
		
		return mv;
	}
	
	//Property exception handler
	@ExceptionHandler(PropertyNotFoundException.class)
	public ModelAndView handlerPropertyNotFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Property not available!");
		
		mv.addObject("errorDescription", "The property you are looking for is not available right now!");
		
		mv.addObject("title", "Property Unavailable");
		
		return mv;
	}
	
	//General exception handler
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Contact Your Administrator!");
		
		mv.addObject("errorDescription", "");
		
		mv.addObject("title", ex.toString());
		
		return mv;
	}

}
