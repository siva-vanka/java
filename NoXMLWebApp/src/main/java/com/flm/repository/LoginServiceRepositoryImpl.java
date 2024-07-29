package com.flm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.User;


@Repository
public class LoginServiceRepositoryImpl  implements LoginServiceRepository{

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void singUpUser(User user) {
		int rowCount = jdbcTemplate.update("INSERT INTO newgen_user (`email`, `password`) VALUES (?, ?)",user.getEmail(),user.getPassword());
		System.out.println("Rows INserted "+rowCount);
	
		
	}

}
