package com.myexpertise.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myexpertise.demo.dataobject.RoleDO;
import com.myexpertise.demo.dataobject.UserDO;
import com.myexpertise.demo.service.RoleService;
import com.myexpertise.demo.service.UserService;
import com.myexpertise.demo.valueobject.UserVO;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private RoleService roleService;
    
    @RequestMapping(value="/user/register", method={RequestMethod.POST})
    @ResponseBody
    public Map<String, Integer> register(@RequestBody UserVO user)
    {
    	// TODO : Validate the user request and throw error if validation fails.
    	Map<String, Integer> response = new HashMap<String, Integer>();
    	UserDO userDO =  new UserDO();
		userDO.setActive(true);
		userDO.setEmailId(user.getEmail());
		userDO.setPassword(user.getPassword());
		// TODO : Have to handle password and password hash
		userDO.setPasswordHash(user.getPassword());
		userDO.setPhoneNumber(user.getPhone());
		userDO.setUserName(user.getName());
		userDO.setCompanyId(user.getCompanyId());
		// Get user role by identifier and set to the user
		RoleDO roleDO = roleService.getRoleByIdentifier("ADMIN");
		userDO.setRole(roleDO);
    	userService.saveUser(userDO);
    	response.put("success", 1);
        return response;
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
