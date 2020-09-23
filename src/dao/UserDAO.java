package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface{
	@Override
	public boolean loginUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		//System.out.println("login verification boolean");
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM USERS");
		while(rs.next())
		{
			String email = rs.getString(1);
			String password = rs.getString(2);
			
			if(email.equalsIgnoreCase(user.getEmail()) && password.equals(user.getPassword())) {
				System.out.println("Credenentials Matching");
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int signUp(User user) throws SQLException {
		// TODO Auto-generated method stub
		String signup = "insert into USERS(EMAIL,PASSWORD) VALUES (?,?)";

		Connection c = null;
		c = ConnectionManager.getConnection();
		//access the string
		PreparedStatement ps = c.prepareStatement(signup);
		ps.setString(1,user.getEmail());
		ps.setString(2,user.getPassword());
		
		int execution = ps.executeUpdate();
		System.out.println(execution);
		return execution;
	}
	
}

