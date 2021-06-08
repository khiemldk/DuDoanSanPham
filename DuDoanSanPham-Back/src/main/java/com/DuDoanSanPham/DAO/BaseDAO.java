package com.DuDoanSanPham.DAO;

import java.io.Serializable;
import java.util.List;


public interface BaseDAO<E> {
	// khai báo các interface để định nghĩa các hàm dùng chung trong việc xử lý với database
	public List<E> finALl();
	public E findById(Class<E> e, Serializable id);
	public List<E> findByProperty(String property, Object value);
	public void save(E instance);
	public void update(E instance);
	public void delete(E instance);
}
