package com.myexpertise.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value="/hello")
	public String hello()
	{
		return "hello";
	}

}
