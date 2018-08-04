package sb.study.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class HomeDao {
	
	@PostConstruct
	public void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL Driver - ClassNotFound!!");
		}		
	}
	
	public Connection createConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "NewSt@rt!70");
		} catch (SQLException se) {
			System.out.println("Error - MySQL - Creating Connection failed" + se.getMessage());
		}
		
		return con;
	}
	
	public int getUserCount() {
		int count = -1;
		
		Connection con = createConnection();
		
		if (con == null)
			return count;
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM users");
			ResultSet rs = ps.executeQuery();
			rs.next(); // cursor가 1번째 row 이전에 있음.
			
			count = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("Error - MySQL - getUserCount failed");
		}
		
		return count;
	}
}
