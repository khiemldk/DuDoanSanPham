package com.DuDoanSanPham.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DuDoanSanPham.DAO.BaseDAO;
import com.DuDoanSanPham.DAO.UserDAO;
import com.DuDoanSanPham.Entity.User;

@Service
public class UserService {
	@Autowired
	private UserDAO<User> userDAO;

	public List<User> getAllCategory(){
		return userDAO.finALl();
	}
	
	public List<User> handleLogin(String name,String pass) {
		return userDAO.handleLogin(name, pass);
	}
	
	public void InsertUser(User user) {
		userDAO.save(user);
	}
	
	public List<User> findByUserName(String name,String value){
		return userDAO.findByProperty(name, value);
	}
}
