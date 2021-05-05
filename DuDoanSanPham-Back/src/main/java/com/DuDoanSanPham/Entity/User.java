package com.DuDoanSanPham.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "user")
public class User {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer id;
	 private String name;
//	 
//	 @OneToMany(mappedBy = "category",fetch = FetchType.EAGER )
//	 @JsonBackReference
//	 @OneToMany
//	 @JoinColumn(name="cate_id")
//	 private Set<Product> product;
//	 
//	 
//	public Set<Product> getProduct() {
//		return product;
//	}
//	public void setProduct(Set<Product> product) {
//		this.product = product;
//	}
	
	private String user_name;
	private String password;
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getActive_flag() {
		return active_flag;
	}
	public void setActive_flag(int active_flag) {
		this.active_flag = active_flag;
	}
	private int active_flag;
}
