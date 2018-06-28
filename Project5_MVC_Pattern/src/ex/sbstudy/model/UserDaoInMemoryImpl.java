package ex.sbstudy.model;

import java.util.HashMap;
import java.util.Map;

// 인-메모리 DB 형식으로 DAO 구현
public class UserDaoInMemoryImpl implements UserDao {

	private static Map<String, User> users = new HashMap<>();

	// 초기값은 Properties 등에서 읽어올 수도 있음
	// 지금은 seongbin 이라는 계정 하나 등록해놓음
	static {
		String id = "seongbin";
		User user = new User("seongbin", "seongbin", "김성빈");
		
		users.put(id, user);
	}
	
	@Override
	public User findById(String id) {
		System.out.println(id + "를 DB에서 검색 중");
		return users.get(id);
	}

	@Override
	public boolean register(User user) {
		System.out.println(user.getId() + "의 회원가입을 처리하는 중");

		User putUser = users.put(user.getId(), user);
		return putUser != null;
	}
}
