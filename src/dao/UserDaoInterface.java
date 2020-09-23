package dao;

import java.sql.SQLException;

import model.User;

interface UserDaoInterface {
	boolean loginUser(User user) throws SQLException;
	int signUp(User user) throws SQLException;
}

