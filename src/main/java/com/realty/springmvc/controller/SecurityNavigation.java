package com.realty.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityNavigation {
	
	@RequestMapping(value="/user-login", method=RequestMethod.GET)
	public ModelAndView loginForm() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/error-login", method=RequestMethod.GET)
	public ModelAndView invalidLogin() {
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("error", true);
		return modelAndView;
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView successLogin() {
		return new ModelAndView("main");
	}

}
