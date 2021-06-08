package com.DuDoanSanPham.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String code;
	private float price;
	private String des;
	private int number_access;
	private int active_flag;
	private String image;
	private int sold; 
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	
	
		private Integer cate_id;
	public Integer getCate_id() {
			return cate_id;
		}
		public void setCate_id(Integer cate_id) {
			this.cate_id = cate_id;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getNumber_access() {
		return number_access;
	}
	public void setNumber_access(int number_access) {
		this.number_access = number_access;
	}
	public int getActive_flag() {
		return active_flag;
	}
	public void setActive_flag(int active_flag) {
		this.active_flag = active_flag;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	 
	 
}
