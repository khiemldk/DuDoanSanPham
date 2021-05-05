package com.DuDoanSanPham.DAO;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(rollbackFor = Exception.class)
public class BaseDAOImplement<E> implements BaseDAO<E> {
	
	// tự động liên kết với sessionFactory để xử lý câu sql( vì java k hiểu được là sql nó là gì mà 
	// chỉ hiểu được nó chỉ là 1 string 
	@Autowired
	SessionFactory sessionFactory;
	
	// hàm này có trên mạng. lấy ra cái tên bảng thôi 
	public String getGenericName() { // Hàm này lấy ra cái tên bảng để cho hibernate hiểu đc
		String s = getClass().getGenericSuperclass().toString();
		Pattern pattern = Pattern.compile("\\<(.*?)\\>");
		Matcher matcher = pattern.matcher(s);
		String generic = "null";
		if (matcher.find()) {
			generic = matcher.group(1);
		}
		return generic;
	}

	public List<E> finALl() {
		// khai báo câu query để tạo ra câu query bên database
		StringBuilder query = new StringBuilder("");
		// cái này ví dụ " select * from (tên bảng = getGenericName()) as as model where model.active_flag = 1)
		query.append(" from ").append(getGenericName()).append(" as model where model.active_flag = 1");
		System.out.print(query);
		// cái này chỉ là để thực hiện cái giao tiếp với sql 
		Session ss = sessionFactory.getCurrentSession();
		// hàm createQuery để thực hiện câu truy vấn.
		Query<E> queryRes = ss.createQuery(query.toString());
		return queryRes.list();
	}

	public E findById(Class<E> e, Serializable id) {
		// TODO Auto-generated method stub
		Session ss = sessionFactory.getCurrentSession();
		return ss.get(e, id);
	}

	public List<E> findByProperty(String property, Object value) {
		StringBuilder queryString = new StringBuilder();
		StringBuilder countRows = new StringBuilder("");
		queryString.append(" from ").append(getGenericName()).append(" as model where model.active_flag=1 and model.").append(property).append("=?1");
		Session ss = sessionFactory.getCurrentSession();
		Query<E> query = ss.createQuery(queryString.toString());
		query.setParameter(1, value);
		return query.getResultList();
	}


	public void save(E instance) {
		Session ss = sessionFactory.getCurrentSession();
		ss.persist(instance);
		ss.clear();
	}


	public void update(E instance) {
		Session ss = sessionFactory.getCurrentSession();
		ss.merge(instance);
	}


	public void delete(E instance) {
		Session ss = sessionFactory.getCurrentSession();
		ss.clear();
		ss.delete(instance);
	}
	
}
