package com.repository;

import java.sql.Types;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.User;
import com.entity.UserRowMapper;

@Repository
public class LoginServiceRepositoryImpl implements LoginServiceRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int signUpUser(User user) {

		int accountNumber = new Random().nextInt(900000) + 100000;

		try {
			int insertQuery = jdbcTemplate.update("insert into jd values(?,?,?,?,?,?,?)",

					user.getFullName(), user.getGender(), user.getMobileNumber(), user.getDob(), user.getPassword(),
					accountNumber, user.getAccountBalance()

			);

			if (insertQuery > 0) {

				return accountNumber;

			}

			else {

				return accountNumber = 0;
			}

		} catch (Exception e) {
			System.out.println("error" + e.getMessage());

			return accountNumber = -2;

		}

	}

	@Override
	public boolean signInUser(String accountNumber, String password) {
		User user = (User) jdbcTemplate.queryForObject("select * from jd where accountNumber =? and password=? ",
				new Object[] { accountNumber, password }, new UserRowMapper());
		String fullName = user.getFullName();
//		String properName = user.setFullName(fullName + " vanka");
		String name = user.getFullName();

		System.out.println(fullName);

		System.out.println(user.getAccountNumber());

		String accountNumber2 = user.getAccountNumber();

		if (accountNumber2 == null) {

			return false;

		} else {

			return true;
		}

	}

	@Override
	public boolean mobileLogin(String mobileNumber, String password) {
		User user = (User) jdbcTemplate.queryForObject("select * from jd where mobileNumber =? and password=? ",
				new Object[] { mobileNumber, password }, new UserRowMapper());
		String fullName = user.getFullName();

		System.out.println(fullName);

		System.out.println(user.getMobileNumber());

		System.out.println("!!!!!!!!" + mobileNumber);

		String mobileNumber1 = user.getMobileNumber();

		if (mobileNumber1 == null) {

			return false;

		} else {

			return true;
		}

	}

	@Override
	public String viewBalance(String accountNumber) {

		System.out.println("AccountNumber is " + accountNumber);

		User user = jdbcTemplate.queryForObject("select *  from jd where accountNumber =?",
				new Object[] { accountNumber }, new UserRowMapper());

		String accountBalance = user.getAccountBalance();
		return accountBalance;

	}

	@Override
	public int withdrawBalance(int accountNumber, int withdrawAmount) {

		System.out.println("AccountNumber is " + accountNumber);

		User user = jdbcTemplate.queryForObject("select * from jd where accountNumber = ?",
				new Object[] { accountNumber }, new UserRowMapper());

		int accountBalance = Integer.parseInt(user.getAccountBalance());

		if (accountBalance >= withdrawAmount) {

			int existingBalance = accountBalance - withdrawAmount;
			String s = String.valueOf(existingBalance);

			String x = String.valueOf(accountNumber);

			jdbcTemplate.update("update jd set accountBalance =? where accountNumber =?", new Object[] { s, x },
					new int[] { Types.VARCHAR, Types.VARCHAR });

			return existingBalance;

		}

		else {

			return -1;
		}

	}

	@Override
	public int depositAmount(int accountNumber, int depositAmount) {

		System.out.println(" AccountNumber is " + accountNumber);

		User user = jdbcTemplate.queryForObject("Select * from jd where accountNumber =?",
				new Object[] { accountNumber }, new UserRowMapper());

		int accountBalance = Integer.parseInt(user.getAccountBalance());

		if (depositAmount > 0) {

			int Balance = accountBalance + depositAmount;

			String s = String.valueOf(Balance);

			String x = String.valueOf(accountNumber);

			jdbcTemplate.update("Update jd set accountBalance=? where accountNumber =?", new Object[] { s, x },
					new int[] { Types.VARCHAR, Types.VARCHAR });

			return Balance;
		}

		else {

			return -1;
		}
	}

	@Override
	public String passwordChange(String accountNumber, String passwordChanged) {

		System.out.println(accountNumber);

		User user = jdbcTemplate.queryForObject("Select * from jd where accountNumber = ?",
				new Object[] { accountNumber }, new UserRowMapper());

		String password = user.getPassword();

		if (passwordChanged != null) {

			System.out.println(passwordChanged);

			jdbcTemplate.update("update jd set password = ? where accountNumber = ?",
					new Object[] { passwordChanged, accountNumber });

			return passwordChanged;

		} else {

			return "No change in password";
		}

	}
}
