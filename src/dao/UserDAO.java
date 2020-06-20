package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface{
	String signup = "insert into USERS VALUES (?,?)";
	String login = "select * from USERS where EMAIL = ? and PASSWORD= ?";
	@Override
	public int signUp(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection c = null;
		c = ConnectionManager.getConnection();
		//access the string
		PreparedStatement ps = c.prepareStatement(signup);
		ps.setString(1,user.getEmail());
		ps.setString(2,user.getPassword());
		
		int execution = ps.executeUpdate();
		return execution;
	}
	@Override
	public boolean loginUser(User user) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		//check the values.
		Connection c = null;
		c = ConnectionManager.getConnection();
		PreparedStatement ps = c.prepareStatement(login);
		ps.setString(1,user.getEmail());
		ps.setString(2,user.getPassword());
		
		ResultSet rs = ps.executeQuery();
		
		return false;
	}
}