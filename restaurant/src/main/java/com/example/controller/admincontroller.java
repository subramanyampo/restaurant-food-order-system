package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.admin;
import com.example.entity.items;
import com.example.entity.userregister;
import com.example.repository.adminrepository;
import com.example.repository.itemsrepository;



@Controller
public class admincontroller {
	@Autowired
	adminrepository adminrepo;
	@Autowired
	itemsrepository item;
	@GetMapping("/")
	public String m1() {
		return "home";
	}
	@GetMapping("/adminlogin")
	public ModelAndView adminlogin() {
		ModelAndView mav=new ModelAndView("adminlogin");
		mav.addObject("admin",new admin());
		
		return mav;
	}
	@GetMapping("/adminregister")
	public ModelAndView adminregister() {
		ModelAndView mav=new ModelAndView("adminregister");
		mav.addObject("admin",new admin());
		return mav;
	}
	@PostMapping("/adminsave")
	public String save(@ModelAttribute("admin")admin a) {
		System.out.println(a.getName());
		adminrepo.save(a);
		
		return "adminlogin";////////////////////////error
		
	}

	@GetMapping("/adminloginprocess")
    public String adminloginProcess(@ModelAttribute("admin") admin u) {
        admin admin = adminrepo.findByNameAndPassword(u.getName(), u.getPassword());
        if (admin != null) {
            
            return "admincontrollermenu";
        } else {
            return "home";
        
        }
	}
	@GetMapping("/gotoadminmenu")
	public String menu() {
		return "admincontrollermenu";
	}
	@RequestMapping("/deletes")
	public ModelAndView deletesitem(@RequestParam int id) {
		item.deleteById(id);
		List<items>c=item.findAll();
		ModelAndView mav=new ModelAndView("userviewallitems");
		mav.addObject("items",c);
		return mav;
		
	}
	@RequestMapping("/update")
	public String updateitem(@RequestParam int id) {
		return "updateitem";
	}
	@RequestMapping("/gotoadditemspage")
	public String gotoadditemspage() {
		return "admincontrollermenu";
	}
	
	
	
}


	
	


