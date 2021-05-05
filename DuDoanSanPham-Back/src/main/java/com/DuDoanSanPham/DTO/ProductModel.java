package com.DuDoanSanPham.DTO;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.DuDoanSanPham.Entity.Product;
import com.DuDoanSanPham.Entity.User;


public class ProductModel {
	
	private Integer id;
	private Float rate;
	private Integer discount;
	private Integer active_flag;
	private Integer user_id;
	private Integer product_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getRate() {
		return rate;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getActive_flag() {
		return active_flag;
	}
	public void setActive_flag(Integer active_flag) {
		this.active_flag = active_flag;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	
	
	
}
