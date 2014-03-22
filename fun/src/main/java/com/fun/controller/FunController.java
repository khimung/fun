package com.fun.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fun.model.SessionDTO;
import com.fun.model.User;
import com.fun.service.IJdbcHandler;
import com.fun.service.UserManager;

@Controller
public class FunController {
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private IJdbcHandler jdbcHandler;

	@RequestMapping(value = "/auth", method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody String auth(@RequestBody User user) throws Exception {
		System.out.println(user.getUsername());
        SessionDTO sessionDTO = userManager.authenticate(user.getUsername(), user.getPassword());
        if(sessionDTO == null){
        	return "{\"result\":\"failed\"}";
        }
        return "{\"result\":\"success\"}";
	}

	@RequestMapping(value = "/users/{gender}", method = RequestMethod.GET)
	public @ResponseBody List<User> users(@RequestParam(value = "start", required = false, defaultValue = "0") Integer start, @PathVariable("gender") String gender) throws Exception {
		List<User> users = userManager.findByGenderGroupByAge(gender, "age", start);
        return users;
	}
	
	@RequestMapping(value="/resource", method=RequestMethod.GET)
	public @ResponseBody String resource(@RequestParam("type") String server) throws Exception {
		if("mysql".equals(server.toLowerCase())){
			return "{\"result\":\"" + jdbcHandler.isAlive() + "\"}";
		}
		return "{\"result\":\"unknown resource\"}";
	}
	
	@RequestMapping(value="/listDir", method=RequestMethod.GET)
	public @ResponseBody String[] listDir(@QueryParam("path") String path) throws Exception {
		if(StringUtils.isEmpty(path)){
			return new String[]{};	
		}
		File file = new File(path);
		if(file.canRead() == true){
			return file.list();
		}
		return new String[]{};	
	}
}
