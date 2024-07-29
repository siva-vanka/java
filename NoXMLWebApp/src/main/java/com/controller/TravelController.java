package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TravelController {
	
	@RequestMapping("/book-travel")
	public String redirectToLogin(HttpServletRequest req, Model model) {
		String fromAddress = req.getParameter("from_address");
		String toAddress = req.getParameter("to_address");
		String travelDate = req.getParameter("travel_date");
		
		System.out.println(String.format("from_address is %s and to_address is %s and travel_date is %s", fromAddress,toAddress,travelDate));
		
		return "success";
	}

}
