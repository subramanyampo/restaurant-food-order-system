package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.items;
import com.example.entity.orders;
//import com.example.entity.items;
//import com.example.entity.orders;
import com.example.entity.user;
//import com.example.entity.userregister;
import com.example.repository.itemsrepository;
import com.example.repository.orderrepository;
import com.example.repository.userregisterrepository;
import com.example.repository.userrepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class orderscontroller {
	@Autowired
	orderrepository orderrepo;
	@Autowired
	itemsrepository itemrepo;
	
	@Autowired
	userregisterrepository r;
	
	// Import statements

	@Controller
	public class OrdersController {

	    @Autowired
	    private orderrepository orderRepo;

	    @Autowired
	    private itemsrepository itemRepo;

	    @Autowired
	    private userregisterrepository userRepo;

	    @GetMapping("/addtocart")
	    public ModelAndView addToCart(@RequestParam int id, @RequestParam int uid, HttpSession session) {
	        ModelAndView mav = new ModelAndView("orderdetails");
	        double totalcost = 0.0;

	        // Retrieve or create a cartItems list from the session
	        List<items> cartItems = (List<items>) session.getAttribute("cartItems");

	        if (cartItems == null) {
	            cartItems = new ArrayList<>();
	        }

	        Optional<user> userOptional = userRepo.findById(uid);

	        if (userOptional.isPresent()) {
	            user user = userOptional.get();

	            List<items> items = itemRepo.findAllById(Collections.singletonList(id));

	            // Assuming items is a list; if it's a single item, use cartItems.add(items.get(0));
	            cartItems.addAll(items);

	            // Uncomment this block if you want to save the order to the repository
	            orders order = new orders();
	            order.setUser(user);
	            order.setItems(cartItems);
	            orderRepo.save(order);
	        } else {
	            System.out.println("User not found");
	            // Handle the case when the user is not found
	        }

	        
	        for (items s : cartItems) {
	            totalcost = totalcost + s.getCost();
	        }

	        // Save the updated cartItems list to the session
	        session.setAttribute("cartItems", cartItems);

	        mav.addObject("uid", uid);
	        mav.addObject("it", cartItems);
	        mav.addObject("totalcost", totalcost);

	        return mav;
	    }
	}
	@PostMapping("/cancelItem")
	public ModelAndView cancelItem(@RequestParam int itemId, @RequestParam int uid, HttpSession session) {
	    ModelAndView mav = new ModelAndView("orderdetails");
	    double totalcost = 0.0;

	    // Retrieve the cartItems list from the session
	    List<items> cartItems = (List<items>) session.getAttribute("cartItems");

	    if (cartItems != null) {
	        // Remove the item with the specified itemId from the cart
	        cartItems.removeIf(item -> item.getId() == itemId);

	        // Recalculate the total cost
	        for (items s : cartItems) {
	            totalcost += s.getCost();
	        }

	        // Save the updated cartItems list to the session
	        session.setAttribute("cartItems", cartItems);
	    } else {
	        // Handle the case when cartItems is not found in the session
	        System.out.println("Cart not found");
	    }

	    mav.addObject("uid", uid);
	    mav.addObject("it", cartItems);
	    mav.addObject("totalcost", totalcost);

	    return mav;
	}

}



	    

