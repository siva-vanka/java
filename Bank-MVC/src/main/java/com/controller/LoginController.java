package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;
import com.repository.LoginServiceRepository;

@Controller
public class LoginController {

	@Autowired

	LoginServiceRepository loginServiceRepository;

	@RequestMapping("/signup")
	public String redirectToSignUp(HttpServletRequest req, Model model) {
		return "signup";

	}

	@RequestMapping("/signin")
	public String redirectToLogin(HttpServletRequest req, Model model) {
		return "signin";

	}

	@RequestMapping("/signinM")
	public String redirectToLoginM(HttpServletRequest req, Model model) {
		return "mobileLogin";

	}

	@RequestMapping("/view-Balance")
	public String viewBalance(HttpServletRequest req, Model model) {

		String accountNumber = req.getParameter("accountNumber");

		System.out.println(accountNumber);

		String existingBalance = loginServiceRepository.viewBalance(accountNumber);

		model.addAttribute("accountBalance", existingBalance);

		System.out.println(String.format("AccountBalance is %s ", existingBalance));

		return "viewBalance";

	}

	@RequestMapping("/withdrawAmount")
	public String withdrawAmount(HttpServletRequest req, Model model) {

		int accountNumber = Integer.parseInt(req.getParameter("accountNumber"));

		System.out.println("Your AccountNumber is !!!!!" + accountNumber);
//		String accountNumber = req.getParameter("accountNumber");

//		System.out.println("YOUr AccountNumber is " + accountNumber);

		int withdrawAmount = Integer.parseInt(req.getParameter("withdrawAmount"));
//		String withdrawAmount = req.getParameter("withdrawAmount");

		System.out.println("Your withdrawAmount is " + withdrawAmount);

		int withdrawBalance = loginServiceRepository.withdrawBalance(accountNumber, withdrawAmount);

		if (withdrawBalance >= 0) {

			model.addAttribute("withdrawBalance", withdrawBalance);

			return "withdrawBalance";
		}

		else {

			return "error";
		}
	}

	@RequestMapping("/depositAmount")
	public String depositAmount(HttpServletRequest req, Model model) {

		int accountNumber = Integer.parseInt(req.getParameter("accountNumber"));

		System.out.println("Your AccountNumber is !!!!!" + accountNumber);

		int depositAmount = Integer.parseInt(req.getParameter("depositAmount"));

		System.out.println("Your depositAmount is " + depositAmount);

		int depositedAmount = loginServiceRepository.depositAmount(accountNumber, depositAmount);

		if (depositedAmount >= 0) {

			model.addAttribute("depositedAmount", depositedAmount);

			return "depositedAmount";
		}

		else {

			return "error";

		}
	}

	@RequestMapping("/passwordChange")
	public String passwordChange(HttpServletRequest req, Model model) {

		String accountNumber = req.getParameter("accountNumber");

		System.out.println("your ps accountNumber !!" + accountNumber);

		String passwordChanged = req.getParameter("passwordChanged");

		System.out.println("your ps password " + passwordChanged);

		loginServiceRepository.passwordChange(accountNumber, passwordChanged);

		if (passwordChanged != null) {

			return "passwordChange";

		} else {

			return "error";
		}

	}

	@RequestMapping("/validate-login")
	public String validateLogin(HttpServletRequest req, Model model) {
		System.out.println("Validater Invoked --");
		String accountNumber = req.getParameter("accountNumber");
		String password = req.getParameter("password");
		System.out.println(accountNumber);
		System.out.println(password);

		boolean status = loginServiceRepository.signInUser(accountNumber, password);
		String existingBalance = loginServiceRepository.viewBalance(accountNumber);

		if (status) {

			model.addAttribute("existingBalance", existingBalance);

			return "BankingOperations";
		} else {
			return "error";
		}

	}

	@RequestMapping("/mobile-Login")
	public String mobileLogin(HttpServletRequest req, Model model) {
		System.out.println("Validater Invoked --");
		String mobileNumber = req.getParameter("mobileNumber");
		System.out.println("YourMobileNumber is " + mobileNumber);
		String password = req.getParameter("password");

		System.out.println("your pass is " + password);
		System.out.println(mobileNumber);
		System.out.println(password);

		boolean status = loginServiceRepository.mobileLogin(mobileNumber, password);

		if (status) {
			model.addAttribute("mobileNumber", "password");

			return "BankingOperations";
		} else {
			return "error";
		}

	}

	@RequestMapping("/create-user")

	public String createUser(HttpServletRequest incomingRequest, Model model) {

		String fullName = incomingRequest.getParameter("fullName");
		String gender = incomingRequest.getParameter("gender");
		String mobileNumber = incomingRequest.getParameter("mobileNumber");
		String dob = incomingRequest.getParameter("dob");
		String password = incomingRequest.getParameter("password");
		String confirmPassword = incomingRequest.getParameter("confirmPassword");
		String accountBalance = incomingRequest.getParameter("accountBalance");

		User user = new User(fullName, gender, mobileNumber, dob, password, accountBalance);

//		loginService.signUpUser(user);

		int accountNumber = 0;
		accountNumber = loginServiceRepository.signUpUser(user);

//		generatedAccountNumber, 0 ,-2

		if (accountNumber == -2) {

			model.addAttribute("error", "duplicateMobileNumber");

			return "error1";

		}

		model.addAttribute("myAccountNumber", accountNumber);
		model.addAttribute("fullName", fullName);

		System.out.println(String.format(
				"fullName %s and gender is %s and mobileNumber is %s and dob is %s and password is %s and confirmPassword is %s   and accountBalance is %s ",
				fullName, gender, mobileNumber, dob, password, confirmPassword, accountBalance));

		return "signin";
	}
}