package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import objects.User;

public interface UserDao {
	boolean addUser(User item);

	boolean editUser(User item);

	boolean delUser(User item);

	ResultSet getUser(int id);

	ResultSet getUser(String username, String userpass);

	ArrayList<ResultSet> getUsers(String multiselect);

	ArrayList<ResultSet> getUsers(String multiselect, int at, int total);
}
