package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.User;
import utility.ConnectionManager;

/*
1.Create a class called as UserDAO inside the dao package.
2.Create a interface called UserDaoInterface with the following methods.
 - int signUp(User user) - boolean loginUser(User user)
3.UserDAO should implement the UserDaoInterface.
4.The signUp method is used to insert User details in the database.
5.The loginUser method checks whether the user exists int the database or not.
*/

public class UserDAO implements UserDaoInterface {
	
	//ConnectionManager cm= new ConnectionManager();
	boolean valid=false;
	Connection con;
	public int signUp(User user) throws Exception {
		con=ConnectionManager.getConnection();
		Statement statement=con.createStatement();
		statement.executeUpdate("INSERT INTO blogger VALUES('"+user.getEmail()+"','"+user.getPassword()+"','"+user.getDate()+"')");
		return 1;
	}

	public boolean loginUser(User user) throws Exception {
		con=ConnectionManager.getConnection();
		Statement statement=con.createStatement();
		ResultSet rs=statement.executeQuery("SELECT email FROM blogger");
		while(rs.next()) {
			if(rs.getString("email").equals(user.getEmail()))
				valid=true;
			else
				valid=false;
		}
		return valid;
	}
	
}