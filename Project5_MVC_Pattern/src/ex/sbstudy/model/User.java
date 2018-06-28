package ex.sbstudy.model;

public class User {

	private String id;
	
	private String password;
	
	private String name;
	
	public User(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	public boolean checkInformationCorrect() {
		return this.id != null && this.password != null && this.name != null;
	}
	
	public boolean checkPasswordIsCorrect(String inputPassword) {
		return this.password.equals(inputPassword);
	}
	
	public void changePassword(String password) {
		this.password = password;
	}

	// 아래 getter/setter는 setAttribute 시에 Java Bean 스펙을 만족해야 해서
	// 필수로 들어가는 메소드들임.
	// 객체지향에선 '악' 임!
	
	public String getId() {
		return this.id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
