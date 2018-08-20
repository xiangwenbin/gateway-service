package com.zhonghui.gateway.controller;


import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhonghui.core.utils.LoggerUtils;


@Controller
@RequestMapping("")
public class IndexController {
	
	
	@RequestMapping(value = { "/info" })
    @ResponseBody
	public String info() {
		try {
			LoggerUtils.runlog("gateway inof : ip "+InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{'status':'UP'}";
	}
}
