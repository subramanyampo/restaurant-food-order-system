package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.user;
import com.example.entity.userregister;
import com.example.repository.userregisterrepository;
import com.example.repository.userrepository;

@Controller
public class usercontroller {
	@Autowired
	userrepository userrepo;
	@Autowired
	userregisterrepository urr;
	@GetMapping("/user-registration")
	public ModelAndView userregistrationpage() {
		ModelAndView mav=new ModelAndView("useregistrationpage");
		mav.addObject("user",new userregister());
		return mav;
	}
	@PostMapping("/save")
	public String saveuserdata(@ModelAttribute("user")userregister u) {
		user r=new user();
		r.setName(u.getName());
		r.setPassword(u.getPassword());
		urr.save(r);
		
		userrepo.save(u);
		return "home";
		
	}
	 @GetMapping("/userlogins")
	    public String userlogins(Model model) {
	        // Add a dummy user object to the model
	        model.addAttribute("user", new userregister()); // Assuming you have a User class
	        return "userlogin";
	    }
	 @GetMapping("/userlogi")
	 public ModelAndView ModelAndView(@ModelAttribute("user") userregister u) {
	     userregister user=userrepo.findByNameAndPassword(u.getName(),u.getPassword());
	     ModelAndView mav=new ModelAndView();
	     
	     if(user!=null) {
	    	 //System.out.println(user);
	    	 //System.out.println(user.getName());
	    	 //System.out.println(user.getPassword());
	    	 //System.out.println(user.getId());
	    	 mav.addObject("userid",user.getId());
	    	 mav.setViewName("userfrontend");
	    	
	    	 
	     }
	     else {
	    	 mav.setViewName("home");
	    	
	    	
	     }
	     return mav;
		 
	     
	 }



}
