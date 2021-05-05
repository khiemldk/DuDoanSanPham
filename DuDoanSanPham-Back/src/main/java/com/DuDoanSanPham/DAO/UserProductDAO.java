package com.DuDoanSanPham.DAO;

import java.util.List;

import com.DuDoanSanPham.DTO.ProductModel;
import com.DuDoanSanPham.DTO.UserProduct_DTO;
import com.DuDoanSanPham.Entity.User_Product;

public interface UserProductDAO<E> extends BaseDAO<E> {
	public List<ProductModel> findUserProduct(int user_id,int product_id);
	public void update(float rate,int id);
	public void insertUserProduct(float user_id, int product_id,float rate);
}
