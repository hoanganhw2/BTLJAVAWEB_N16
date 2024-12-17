package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import basic.ShareControl;
import objects.Cart;
import objects.User;

public interface UserDao extends ShareControl {
	boolean addUser(User item);

	boolean editUser(User item);

	boolean delUser(User item);
	boolean isUser(String name);
	ResultSet getUser(int id);
	
	ResultSet getUser(String username, String userpass);

	ArrayList<ResultSet> getUsers(String multiselect);

	ArrayList<ResultSet> getUsers(String multiselect, int at, int total);
	
	
}
