package dao;

import java.io.IOException;
import java.sql.SQLException;

import model.User;

public interface UserDaoInterface{
	
	public int signUp(User user) throws Exception;
	public boolean loginUser(User user) throws ClassNotFoundException, SQLException, IOException ;
	
}