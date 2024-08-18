package com.repository;

import java.sql.SQLIntegrityConstraintViolationException;

import com.entity.User;

public interface LoginServiceRepository {

	int signUpUser(User user);

	boolean signInUser(String accountNumber, String password);

	String viewBalance(String accountNumber);

	int withdrawBalance(int accountNumber, int withdrawAmount);

	int depositAmount(int accountNumber, int depositAmount);

	String passwordChange(String accountNumber, String password);

	boolean mobileLogin(String mobileNumber, String password);

}
