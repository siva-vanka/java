package com.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {

		User user = new User();

		user.setAccountNumber(rs.getString("accountNumber"));
		user.setPassword(rs.getString("password"));

		user.setAccountBalance(rs.getString("accountBalance"));
		user.setGender(rs.getString("gender"));
		user.setDob(rs.getString("dob"));

		user.setFullName(rs.getString("fullName"));
		user.setMobileNumber(rs.getString("mobileNumber"));

		return user;
	}

}
