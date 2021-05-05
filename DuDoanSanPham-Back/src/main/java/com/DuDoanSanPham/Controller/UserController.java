package com.DuDoanSanPham.Controller;

import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DuDoanSanPham.Entity.User;
import com.DuDoanSanPham.Service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping("/user")
	public List<User> getListCate(){
		return userService.getAllCategory();
	}
	@PostMapping("/login")
	public JSONObject handleLogin(@RequestBody User user) {
		List<User> list = userService.handleLogin(user.getUser_name(), user.getPassword());
		JSONObject json = new JSONObject();
		
		if (list.size() == 0) {
			json.put("message", false);
		}
		else {
			json.put("message", true);
			json.put("id", list.get(0).getId());
		}
		return json;
	}
	
	@PostMapping("/user/save")
	public JSONObject saveUser(@RequestBody User user) {
		JSONObject json = new JSONObject();
		List<User> list = userService.findByUserName("user_name", user.getUser_name());
		if (list.size() > 0) {
			json.put("message", false);
		} else {
			userService.InsertUser(user);
			json.put("message", true);
		}
		return json;
	}
	
	@PostMapping("/user/check")
	public JSONObject checkUser(@RequestBody User user) {
		JSONObject json = new JSONObject();
		List<User> list = userService.findByUserName("user_name", user.getUser_name());
		if (list.size() > 0) {
			json.put("message", false);
		} else {
			json.put("message", true);
		}
		return json;
	}
}
