package com.example.suspectservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan("com.example.suspectservice")
public class FirebaseController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	//http://localhost:8080/SuspectServiceApplication/getSuspectData
	@RequestMapping(value = "/getSuspectData", method = RequestMethod.GET)
	public @ResponseBody String getData() {
		logger.info("getSuspectData ::: >>>> ");
		return "Hello World !!!";
	}
	
	@RequestMapping(value = "/getSuspectData2", method = RequestMethod.GET)
	public @ResponseBody String getData2() {
		logger.info("getSuspectData ::: >>>> ");
		return "Hello World 222 !!!";
	}

}
