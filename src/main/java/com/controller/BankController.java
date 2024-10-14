package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BankController {

	@RequestMapping("/Account-access")
	public String redirectToLogin(HttpServletRequest req, Model model) {
		String accountNumber = req.getParameter("accountNumber");
		String password = req.getParameter("password");

		System.out.println(String.format("accountNumber is %s and password is %s ", accountNumber, password));

		return "BankingOperations";
	}

//	@RequestMapping("/Account-access")
	public String mobileLogin(HttpServletRequest req, Model model) {
		String mobileNumber = req.getParameter("mobileNumber");
		String password = req.getParameter("password");

		System.out.println(String.format("accountNumber is %s and password is %s ", mobileNumber, password));

		return "BankingOperations";
	}

	@RequestMapping("/password-page")
	public String password(HttpServletRequest req, Model model) {

		return "passwordpage";
	}

}
