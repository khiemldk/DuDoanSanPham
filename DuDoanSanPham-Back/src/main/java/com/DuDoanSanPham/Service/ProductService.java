package com.DuDoanSanPham.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DuDoanSanPham.DAO.ProductDAO;
import com.DuDoanSanPham.Entity.Product;

@Service
public class ProductService {
	// tự động liên kết đến productDAO để  thực hiện các hàm đã được tạo trong ProductDAO 
	@Autowired
	private ProductDAO<Product> productDAO;
	
	public List<Product> getProduct( ) {
		return productDAO.finALl();
	}
	public List<Product> getListFromProp(String property,Object value) {
		return productDAO.findByProperty(property, value);
	}
	public Product findById(int id) {
		return productDAO.findById(Product.class, id);
	}
	public void saveProduct(Product product) {
		productDAO.save(product);
	}
}
