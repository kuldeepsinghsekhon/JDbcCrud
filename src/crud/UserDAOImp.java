package crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImp implements UserDAO {
	private static Connection conn = null;

	public UserDAOImp() {

	}

	@Override
	public boolean addUser(User user) {
		Statement stmt;
		conn = DbUtil.getConnection();
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into users(email,name,password) values('" + user.getEmail() + "','"
					+ user.getName() + "','" + user.getPassord() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		return false;
	}

	@Override
	public void deleteUser(int userId) {
		Statement stmt;
		conn = DbUtil.getConnection();
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("delete from users where id=" + userId);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
	}

	@Override
	public void updateUser(User user) {
		Statement stmt;
		conn = DbUtil.getConnection();
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("update users set email='" + user.getEmail() + "',name='" + user.getName()
					+ "',password='" + user.getPassord() + "')");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}

	}

	@Override
	public List<User> getAllUsers() {
		Statement stmt;
		conn = DbUtil.getConnection();
		List<User> users = new ArrayList<User>();
		try {
			stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("select * from users");
			while (res.next()) {
				User user = new User();
				user.setId(res.getInt(1));
				user.setEmail(res.getString(2));
				user.setName(res.getString(3));
				user.setPassord(res.getString(4));
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		return users;
	}

	@Override
	public User getStudentById(int userId) {
		Statement stmt;
		conn = DbUtil.getConnection();
		User user = new User();
		try {
			stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("select * from users where id=" + userId);
			while (res.next()) {
				user.setId(res.getInt(1));
				user.setEmail(res.getString(2));
				user.setName(res.getString(3));
				user.setPassord(res.getString(4));
			}
		} catch (Exception e) {
		} finally {
			DbUtil.closeConnection();
		}
		return user;
	}

}
