package ex.sbstudy.model;

public class UserService {
	
	/* Singleton */
	private UserDao userDao;
	
	private static UserService instance;
	
	private UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public static UserService getInstance() {
		if (instance == null) {
			UserDao userDao = new UserDaoInMemoryImpl();
			instance = new UserService(userDao);
		}
		return instance;
	}
	/* Singleton */
	
	public boolean register(String id, String password, String name) {
		User newUser = new User(id, password, name);
		
		return newUser.checkInformationCorrect() && userDao.register(newUser);
	}
	
	public User login(String id, String password) {
		if (id == null) 
			return null;
		
		User user = userDao.findById(id);
		if (user == null) 
			return null;
		
		if (user.checkPasswordIsCorrect(password)) 
			return userDao.findById(id);
		
		return null;
	}
}
