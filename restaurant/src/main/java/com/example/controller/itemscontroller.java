package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.items;
import com.example.repository.itemsrepository;

//import antlr.collections.List;

@Controller
public class itemscontroller {
	@Autowired
	itemsrepository itemrepo;
	@GetMapping("/additem")
	public ModelAndView additemss() {
		ModelAndView mav=new ModelAndView("additem");
		mav.addObject("items",new items());
		return mav;
	}
	@PostMapping("/items")
	public ModelAndView saveitem(@ModelAttribute("items")items item) {
		
		itemrepo.save(item);
		ModelAndView mav=new ModelAndView("admincontrollermenu");
		return mav;
		
	}
	@GetMapping("/viewallitems")
	public ModelAndView allItemsView() {//@RequestParam int id
		//System.out.println(id+"this is view all items");
	    List<items> itemList = itemrepo.findAll();
	    ModelAndView mav = new ModelAndView("userviewallitems");//viewallitemss
	    mav.addObject("items", itemList);  // Use "items" instead of "item"

	    return mav;
	}
	@GetMapping("/userviewallitems")
	public ModelAndView ItemsView(@RequestParam int uid) {//uid
	    List<items> itemList = itemrepo.findAll();
	    ModelAndView mav = new ModelAndView("viewallitemss");//userviewallitems
	    mav.addObject("id",uid);//
	    mav.addObject("items", itemList);  // Use "items" instead of "item"

	    return mav;
	}
	@GetMapping("/s")
	public ModelAndView useritems(@RequestParam int id) {
		System.out.println(id+" add itms to ur card");
	    List<items> itemList = itemrepo.findAll();
	    ModelAndView mav = new ModelAndView("view");
	    mav.addObject("items", itemList);  // Use "items" instead of "item"
	    mav.addObject("id",id);

	    return mav;
	}


}
