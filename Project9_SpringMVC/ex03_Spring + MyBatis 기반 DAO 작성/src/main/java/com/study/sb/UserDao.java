package com.study.sb;

public interface UserDao {

	void register(User newUser);
	
	User getUserByEmail(String email);
	
	User getUserByEmailAndPw(String email, String password);
}
