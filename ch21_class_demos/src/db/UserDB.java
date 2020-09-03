package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.User;

public class UserDB {
	
	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs";
		String username = "prs_user";
		String pwd = "sesame";
		Connection conn = DriverManager.getConnection(dbURL,
				username,pwd);
		return conn;
	}
	
	// NOTE:  uses Statement rather than PreparedStatement
	public List<User> list() throws SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM User";
		List<User> users = new ArrayList<>();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			User u = createUserFromResultSet(rs);
			users.add(u);
		}
		rs.close();
		return users;
	}


	// NOTE:  uses Statement rather than PreparedStatement
	public User get(int id) throws SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM User"
					+ "	WHERE ID = "+id;
		User user = null;
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			user = createUserFromResultSet(rs);
		}
		rs.close();
		return user;
	}
	
	public int addUser(User u) {
		int rowCount = 0;
		String sql = "insert into user (UserName, "+
					 "Password, FirstName, LastName, "+
					 "PhoneNumber, Email, IsReviewer, "+
					 "IsAdmin) VALUES "+
					 "(?, ?, ?, ?, ?, ?, ?, ?);";
		try (PreparedStatement ps = getConnection().
				prepareStatement(sql);){
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getPhoneNumber());
			ps.setString(6, u.getEmail());
			ps.setBoolean(7, u.isReviewer());
			ps.setBoolean(8, u.isAdmin());
			rowCount = ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	// change the email address only
	public int updateUser(User u) {
		int rowCount = 0;
		String sql = "update user set Email = ? "+
					 "where id = ?";
		try (PreparedStatement ps = getConnection().
				prepareStatement(sql)){
			ps.setString(1, u.getEmail());
			ps.setInt(2, u.getId());
			rowCount = ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int deleteUser(User u) {
		int rowCount = 0;
		String sql = "delete from user "+
					 "where id = ?";
		try (PreparedStatement ps = getConnection().
				prepareStatement(sql)){
			ps.setInt(1, u.getId());
			rowCount = ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	private User createUserFromResultSet(ResultSet rs) throws SQLException {
		// parse user row into user pojo
		int id = rs.getInt("ID");
		String uname = rs.getString("userName");
		String pwd = rs.getString("password");
		String fname = rs.getString("firstName");
		String lname = rs.getString("lastName");
		String phone = rs.getString("phoneNumber");
		String email = rs.getString("email");
		boolean rvw = rs.getBoolean("isReviewer");
		boolean adm = rs.getBoolean("isAdmin");
		User u = new User(id,uname,pwd,fname,lname,phone,
				email, rvw,adm);
		return u;
	}
	
}
