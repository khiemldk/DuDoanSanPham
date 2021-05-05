package com.DuDoanSanPham.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DuDoanSanPham.DAO.UserProductDAO;
import com.DuDoanSanPham.DTO.ProductModel;
import com.DuDoanSanPham.DTO.UserProduct_DTO;
import com.DuDoanSanPham.Entity.Product;
import com.DuDoanSanPham.Entity.User_Product;

@Service
public class UserProductService {
	@Autowired
	private UserProductDAO<User_Product> userProductDAO;
	
	public List<User_Product> getAll() {
		return userProductDAO.finALl();
	}
	public List<User_Product> getListFromProp(String property,Object value) {
		return userProductDAO.findByProperty(property, value);
	}
	
	public void saveUserProduct(User_Product user_Product) {
		userProductDAO.update(user_Product);
	}
	
	public void updateUserProduct(UserProduct_DTO userProduct_DTO) {
		userProductDAO.update(userProduct_DTO.getRate(), userProduct_DTO.getId());
	}
	
	public void InsertUserProduct(UserProduct_DTO userProduct_DTO) {
		userProductDAO.insertUserProduct(userProduct_DTO.getUser_id(),userProduct_DTO.getProduct_id() , userProduct_DTO.getRate());
	}
	
	public List<ProductModel> getUserProduct(int user_id,int product_id) {
		return userProductDAO.findUserProduct(user_id, product_id);
	}
}
