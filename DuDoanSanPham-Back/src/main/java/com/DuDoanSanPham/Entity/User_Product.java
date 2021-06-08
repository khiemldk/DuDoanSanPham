package com.DuDoanSanPham.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "user_product")
public class User_Product {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer id;
	private float rate;
	private int discount;
	private int active_flag;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="user_id",updatable = false)
	private User user;
	@ManyToOne(targetEntity = Product.class)
	@JoinColumn(name="product_id",updatable = false)
	private Product product;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getActive_flag() {
		return active_flag;
	}
	public void setActive_flag(int active_flag) {
		this.active_flag = active_flag;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
