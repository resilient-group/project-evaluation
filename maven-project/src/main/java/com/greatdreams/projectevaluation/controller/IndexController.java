package com.greatdreams.projectevaluation.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.greatdreams.projectevaluation.dao.AdminDao;
import com.greatdreams.projectevaluation.dao.NewsDao;
import com.greatdreams.projectevaluation.domain.News;

@Controller
public class IndexController {
	
	//private static final Logger logger= Logger.getLogger(IndexController.class);
	
	@Autowired
	private NewsDao newsDao;
	
	@Autowired
	private AdminDao adminDao;

	
	//返回给客户端信息
	@RequestMapping(value="/")
	public ModelAndView index() {
//		if(logger.isDebugEnabled())
//			logger.debug("the user is fecthing homepage of this website");
		Map<String , Set<News>> newsMap = new HashMap<String , Set<News>>();
		Set<News> allNews = newsDao.selectAllNews();
		newsMap.put("allNews", allNews);
		System.out.println(adminDao.selectPasswordByName("jack"));
		return new ModelAndView("index" , newsMap);
	}
	//返回给客户端信息
	@RequestMapping(value="/{id}")
	public ModelAndView index1(@PathVariable int id) {
//		if(logger.isDebugEnabled())
//			logger.debug("the user is fecthing homepage of this website");
		Map<String , Set<News>> newsMap = new HashMap<String , Set<News>>();
		Set<News> allNews = newsDao.selectAllNews();
		newsMap.put("allNews", allNews);
		System.out.println(adminDao.getClass());
		System.out.println(((News)newsDao.selectNewsById(id)).getTitle());
		return new ModelAndView("index" , newsMap);
	}

	
	@RequestMapping(value="/index.html")
	public String index2() {
//		if(logger.isDebugEnabled())
//			logger.debug("the user is fecthing homepage of this website");
		return "index";
	}
	
	@RequestMapping(value="/index.jsp")
	public String index3() {
//		if(logger.isDebugEnabled())
//			logger.debug("the user is fecthing homepage of this website");
		return "index";
	}
	
	@RequestMapping(value="/default.html")
	public String index4() {
//		if(logger.isDebugEnabled())
//			logger.debug("the user is fecthing homepage of this website");
		return "index";
	}

}
