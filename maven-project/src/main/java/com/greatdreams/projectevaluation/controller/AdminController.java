package com.greatdreams.projectevaluation.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greatdreams.projectevaluation.dao.AdminDao;
import com.greatdreams.projectevaluation.domain.Admin;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	@Autowired
	private AdminDao adminDao;
	
	@RequestMapping("/")
	public String index() {
		return "admin/index";
	}
	
	@RequestMapping(value="/addAdmin")
	public void addAdminJson(@RequestBody Admin admin , HttpServletRequest request , HttpServletResponse response) throws IOException{
		//{"name":"name","password","password"}
		String info = "{\"name\":\" "+ admin.getName() +" \",\"password\":\" "+ admin.getPassword()+" \"}";
		Writer out = response.getWriter();
		response.setContentType("application/json");//返回json格式的数据
		out.write(info);

		System.out.println(admin.getClass().getName());
		//adminDao.insertAdmin(admin);
		System.out.println(adminDao.selectPasswordByName("buildhappy"));
	}
	
}
