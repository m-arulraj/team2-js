package com.arul.ins.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeActionController {

	private final Logger log = LoggerFactory.getLogger(HomeActionController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		log.debug("index service");
		return "welcome";
	}

}
