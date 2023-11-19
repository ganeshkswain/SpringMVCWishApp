package com.nt.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMessageService;

@Controller("wish_controller")
public class WishMessageOperationController {
	
	@Autowired
	private IWishMessageService service;

	@RequestMapping("/wish")
	public String fetchWishMessage(Map<String, Object> map) {
		// shared memory class name
		System.out.println("shared memory object class name::" + map.getClass());
		// use service
		String msg = service.getWishMessage();
		// keep Data in model attributes'
		map.put("wMsg", msg);
		map.put("sysDate", new Date());
		// return model and view
		return "show_result";
	}

}
