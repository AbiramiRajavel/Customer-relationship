package com.example.Abirami;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Usercontroller {
	
	@Autowired
	User_Repo rpo;
    
	@RequestMapping("/userlog-In")
	public String login()
	{
	
		return "userlog-In";
	}
	
	@RequestMapping("/usersignUp")
	public String signUp(User_details user) {
		String mail=user.getEmail();
		int c=0;
		if(mail==null)
			return "usersignUp";
		for(User_details hp:rpo.findAll()) {
			if(mail.equals(hp.getEmail())) {
				c++;
			}
		}
		if(c==0)
		rpo.save(user);
		
		return "usersignUp";
	}
	@RequestMapping("/user-register")
	public String register(User_login log) {
		int c=0;
		System.out.println(log.getEmail());
		for(User_details hp:rpo.findAll()) {
			if(hp.getEmail()==log.getEmail()) {
				c++;
				System.out.println(c);
			}
		}
		if(c==0)
		return "user-register";
		else
			return "userlog-In";
	}
	
}
