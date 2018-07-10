/**  
 * ---------------------------------------------------------------------------
 * Copyright (c) 2017, xsjt- All Rights Reserved.
 * Project Name:springboot-test  
 * File Name:StudentController.java  
 * Package Name:com.xsjt.controller
 * Author   Joe
 * Date:2017年11月6日下午4:27:40
 * ---------------------------------------------------------------------------  
*/  
  
package com.github.wxiaoqi.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**  
 * ClassName:StudentController 
 * Date:     2017年11月6日 下午4:27:40
 * @author   Joe  
 * @version    
 * @since    JDK 1.8
 */
@Controller
public class StudentController {


	@Autowired
	App app;
	@Autowired
	HttpServletRequest request;
	/**
	 * view:(跳转到JSP界面).  
	 * @author Joe
	 * Date:2017年11月6日下午4:29:27
	 *
	 * @param map
	 * @return
	 */
	@RequestMapping(value = {"/sign", "/view"})
	public String view(@RequestParam(value = "sign") String sign) {
		request.setAttribute("signStr",sign);
//		map.put("name", "SpringBoot");
//		map.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		return "index";
	}
	
	/**
	 * freemarker:(跳转到 freemarker.ftl).  
	 * @author Joe
	 * Date:2017年11月6日下午4:52:19
	 *
	 * @param map
	 * @return
	 */
	@RequestMapping("/signDoyin")
	public @ResponseBody String freemarker(@RequestParam(value = "sign") String sign) throws  Exception{
//		request.setAttribute("signStr",sign);
//		request.setAttribute("signStr",sign);

//		System.out.println(sign+"zifu");
		String result= app.getSign(sign);
//		map.clear();
//        map.put("sign", result);

		return result;
	}
	

	
}