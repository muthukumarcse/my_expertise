package com.myexpertise.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myexpertise.demo.dataobject.UserDO;
import com.myexpertise.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
    
    @RequestMapping(value="/user/register", method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String register()
    {
    	UserDO userDO =  new UserDO();
		userDO.setActive(true);
		userDO.setEmailId("muthukumar.paramasivam@gmail.com");
		userDO.setPassword("123456");
		userDO.setPasswordHash("werastsdf");
		userDO.setPhoneNumber("9659003535");
		userDO.setUserName("Muthu");
		userDO.setCompanyId("RAV-181");
		userDO.setRole(1);
    	userService.saveUser(userDO);
    	
        return "muthu";
    }
    
    @RequestMapping(value="/users", method=RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<String> getUsers()
    {    	
    	ArrayList<String> al = new ArrayList<String>();
		al.add("a");
		al.add("b");
		al.add("c");
		return al;
    }
}
