package com.DuDoanSanPham.DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.DuDoanSanPham.Entity.Product;

// khai báo component để lúc mình autowired nó có thể liên kết đến thằng này
@Component
public class ProductDTO {
	private Integer id;
	private Integer cate_id;
	private String name;
	private String code;
	private float price;
	private String des;
	private int number_access;
	private int active_flag;
	private String image;
//	private float discount;
//	private float rate;
	private int sold; 
	
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	
//	public float getDiscount() {
//		return discount;
//	}
//	public void setDiscount(float discount) {
//		this.discount = discount;
//	}
//	public float getRate() {
//		return rate;
//	}
//	public void setRate(float rate) {
//		this.rate = rate;
//	}
	public ProductDTO() {
		this.knn = 0;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCate_id() {
		return cate_id;
	}
	public void setCate_id(Integer cate_id) {
		this.cate_id = cate_id;
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
	
	private double knn;
	
	public double getKnn() {
		return knn;
	}
	public void setKnn(double knn) {
		this.knn = knn;
	}
	public ProductDTO convertElement(Product vl) {
		ProductDTO dto = new ProductDTO();
		dto.setId(vl.getId());
		dto.setCate_id(vl.getCate_id());
		dto.setCode(vl.getCode());
		dto.setName(vl.getName());
		dto.setImage(vl.getImage());
		dto.setActive_flag(vl.getActive_flag());
		dto.setNumber_access(vl.getNumber_access());
		dto.setPrice(vl.getPrice());
		dto.setDes(vl.getDes());
		dto.setSold(vl.getSold());
		return dto;
	}
	public List<ProductDTO> convertDTO(List<Product> values){
		if(values.size() ==0) {
			return null;
		}
		List<ProductDTO> listProDTO = new ArrayList<>();
		for (Product vl : values) {
			ProductDTO dto = new ProductDTO();
			dto.setId(vl.getId());
			dto.setCate_id(vl.getCate_id());
			dto.setCode(vl.getCode());
			dto.setName(vl.getName());
			dto.setImage(vl.getImage());
			dto.setActive_flag(vl.getActive_flag());
			dto.setNumber_access(vl.getNumber_access());
			dto.setPrice(vl.getPrice());
			dto.setDes(vl.getDes());
			dto.setSold(vl.getSold());
			listProDTO.add(dto);
		}
		return listProDTO;
	}
	
	
	
}
