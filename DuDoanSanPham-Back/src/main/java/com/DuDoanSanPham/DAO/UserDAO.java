package com.DuDoanSanPham.DAO;

import java.util.List;

public interface UserDAO<E> extends BaseDAO<E>{
	public List<E> handleLogin(String name,String pass);
}
