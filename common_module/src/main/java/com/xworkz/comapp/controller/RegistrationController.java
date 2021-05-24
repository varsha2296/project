package com.xworkz.comapp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.comapp.dto.RegistrationDTO;
import com.xworkz.comapp.service.RegistrationService;

@Controller
@RequestMapping("/")
public class RegistrationController {

	private static Logger logger;

	@Autowired
	private RegistrationService registrationService;

	public RegistrationController() {
		logger = Logger.getLogger(getClass());
	}

	@PostMapping("register.do")
	public ModelAndView register(RegistrationDTO registrationDTO) {
		logger.info("invoked register()");
		ModelAndView modelAndView = new ModelAndView("index");
		try {
			String msg = registrationService.validateAndSave(registrationDTO);
			modelAndView.addObject("msg", msg + registrationDTO.getFullName());
		} catch (Exception e) {
			logger.error("Exception occurred" + e.getMessage(), e);
		}
		return modelAndView;
	}
}
