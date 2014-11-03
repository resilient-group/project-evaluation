package com.greatdreams.projectevaluation.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	private static final Logger logger= Logger.getLogger(IndexController.class);
	
	@RequestMapping(value="/")
	public String index() {
		
		if(logger.isDebugEnabled())
			logger.debug("the user is fecthing homepage of this website");
		
		return "index";
	}
	
	@RequestMapping(value="/index")
	public String index1() {
		if(logger.isDebugEnabled())
			logger.debug("the user is fecthing homepage of this website");
		return "index";
	}
	
	@RequestMapping(value="/index.html")
	public String index2() {
		if(logger.isDebugEnabled())
			logger.debug("the user is fecthing homepage of this website");
		return "index";
	}
	
	@RequestMapping(value="/index.jsp")
	public String index3() {
		if(logger.isDebugEnabled())
			logger.debug("the user is fecthing homepage of this website");
		return "index";
	}
	
	@RequestMapping(value="/default.html")
	public String index4() {
		if(logger.isDebugEnabled())
			logger.debug("the user is fecthing homepage of this website");
		return "index";
	}
	
	@RequestMapping(value="/default.jsp")
	public String index5() {
		if(logger.isDebugEnabled())
			logger.debug("the user is fecthing homepage of this website");
		return "index";
	}
}
