package com.study.sb;

import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	private static final String namespace = "com.study.sb.UserMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void register(User newUser) {
		sqlSession.insert(namespace + ".register", newUser);
	}

	@Override
	public User getUserByEmail(String email) {
		return sqlSession.selectOne(namespace + ".getUserByEmail", email);
	}

	@Override
	public User getUserByEmailAndPw(String email, String password) {
		
		Map<String, String> params = new HashMap<>();
		params.put("email", email);
		params.put("password", password);
		
		return sqlSession.selectOne(namespace + ".getUserByEmailAndPw", params);
	}

}
