package com.DuDoanSanPham.DTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.DuDoanSanPham.Entity.Product;
import com.DuDoanSanPham.Entity.User_Product;

@Component
public class UserProduct_DTO {
	private Integer id;
	private Integer user_id;
	private Integer product_id;
	private float rate;
	private int discount;
	private int active_flag;
	private double knn;
	public double getKnn() {
		return knn;
	}
	public void setKnn(double knn) {
		this.knn = knn;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public List<UserProduct_DTO> convertDTO(List<User_Product> values){
		if(values.size() ==0) {
			return null;
		}
		List<UserProduct_DTO> listProDTO = new ArrayList<>();
		for (User_Product vl : values) {
			UserProduct_DTO dto = new UserProduct_DTO();
			dto.setId(vl.getId());
			dto.setProduct_id(vl.getProduct().getId());
			dto.setUser_id(vl.getUser().getId());
			dto.setDiscount(vl.getDiscount());
			dto.setRate(vl.getRate());
			listProDTO.add(dto);
		}
		return listProDTO;
	}
}
