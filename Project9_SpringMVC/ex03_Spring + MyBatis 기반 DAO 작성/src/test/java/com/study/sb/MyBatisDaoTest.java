package com.study.sb;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class MyBatisDaoTest {

	@Autowired
	private UserDao dao;
	
	// 이전에 아래 정보가 DB에 삽입되어 있어야 함
	private final String email="seongbin@gmail.com";
	private final String password="1234";

	@Test
	public void testRegister() {
		User userSeEun = new User("seEun@gmail.com", "seEunPassword", "심세은");
		
		dao.register(userSeEun);
	}
	
	@Test
	public void testGetUserByEmail() {		
		User userSeongbin = dao.getUserByEmail(email);
		System.out.println("by Email: " + userSeongbin);

		assertEquals(userSeongbin.getEmail(), email);
	}
	
	@Test
	public void testGetUserByEmailAndPw() {
		User userSeongbin = dao.getUserByEmailAndPw(email, password);
		
		assertEquals(userSeongbin.getEmail(), email);
		assertEquals(userSeongbin.getPassword(), password);
	}
}
