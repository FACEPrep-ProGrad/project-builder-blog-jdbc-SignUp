package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface {
	@Override
	public int signUp(User user) throws Exception {
		String signup = "insert into Users values(?,?)";
		// create a connection to the database
		Connection connection = null;
		connection = ConnectionManager.getConnection();
		PreparedStatement statement = connection.prepareStatement(signup);
		statement.setString(1, user.getEmail());
		statement.setString(2, user.getPassword());
		int ec = statement.executeUpdate();
		return ec;
	}

	@Override
	public boolean loginUser(User user) {
		System.out.println("Entering into login part");
		boolean b = false;
		try {
			String login = "select * from users where email = ? and password=?";
			System.out.println(login);
			// connect to the database
			Connection connection = null;
			connection = ConnectionManager.getConnection();
			System.out.println("connection established" + connection);
			PreparedStatement statement = connection.prepareStatement(login);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			ResultSet resultSet = statement.executeQuery();
			System.out.println(resultSet);
			b = resultSet.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}