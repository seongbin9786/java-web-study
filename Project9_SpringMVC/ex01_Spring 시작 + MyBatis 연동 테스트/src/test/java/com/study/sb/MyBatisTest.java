package com.study.sb;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class MyBatisTest {

	@Autowired
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void test() {
		try (SqlSession session = sqlFactory.openSession()) {
			assertNotNull(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
