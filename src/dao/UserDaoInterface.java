package dao;

import model.User;

public interface UserDaoInterface{
    public int signUp(User user) throws Exception;
    public boolean loginUser(User user) throws Exception;
}