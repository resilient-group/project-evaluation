package com.greatdreams.projectevaluation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greatdreams.projectevaluation.dao.AdminDao;
import com.greatdreams.projectevaluation.domain.Admin;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	private AdminDao adminDao;

	@RequestMapping("/")
	public String index() {
		return "admin/index";
	}

	@RequestMapping(value = "/addAdmin")
	public void addAdminJson(@RequestBody Admin admin,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// {"name":"name","password","password"}
		String info = "{\"name\":\" " + admin.getName()
				+ " \",\"password\":\" " + admin.getPassword() + " \"}";
		Writer out = response.getWriter();
		response.setContentType("application/json");// 返回json格式的数据
		out.write(info);

		System.out.println(admin.getClass().getName());
		// adminDao.insertAdmin(admin);
		System.out.println(adminDao.selectPasswordByName("buildhappy"));
	}

	// 获取一个用户时，将直接返回json类型的数据
	// 该方法只处理get方法并且是text/xml,application/json类型的请求
	/*
	 * @RequestMapping(value="/getAdmin/jack" , method=RequestMethod.GET,
	 * //headers={"Accept=text/xml,application/json"}, produces =
	 * {"application/json", "application/xml" }) public @ResponseBody Admin
	 * getAdmin(String name){ name = "jack"; System.out.println("in getAdmin");
	 * Admin admin = new Admin(); admin.setId(110); admin.setName(name);
	 * admin.setPassword(adminDao.selectPasswordByName(name));
	 * System.out.println(admin); return admin; }
	 */
	@RequestMapping(value = "/getAdmin/{name}", method = RequestMethod.GET,
					produces ="application/json")
	@ResponseBody
	public Admin  getAdmin(@PathVariable String name) {
		//String name = "jack";
		System.out.println("in getAdmin");
		Admin admin = new Admin();
		admin.setId(110);
		admin.setName(name);
		admin.setPassword(adminDao.selectPasswordByName(name));
		System.out.println(admin);
	    return admin;
		
	}

	@RequestMapping(value = "/getAdmin")
	public String getAdmin() {
		return "admin/getAdmin";
	}

}
