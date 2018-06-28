package ex.sbstudy.model;

// DAO = Data Access Object
// DB와 상호작용하는 객체로
// 나머지 객체들과 DB의 결합을 제거하는 중개자 역할을 한다.
public interface UserDao {

	// id 값으로 DB의 User 테이블에서 조회한 후 반환한다.
	User findById(String id);
	
	// 회원가입한다.
	boolean register(User user);
}
