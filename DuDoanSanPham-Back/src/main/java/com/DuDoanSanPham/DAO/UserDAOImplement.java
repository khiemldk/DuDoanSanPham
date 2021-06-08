package com.DuDoanSanPham.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.DuDoanSanPham.Entity.User;


@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDAOImplement extends BaseDAOImplement<User> implements UserDAO<User>{

	@Override
	public List<User> handleLogin(String name,String pass) {
		StringBuilder queryString = new StringBuilder("");
		queryString.append(" from ").append(getGenericName()).append(" as model where model.active_flag=1 and model.user_name")
			 .append("=?1").append(" and model.password").append("=?2");
		Session ss = sessionFactory.getCurrentSession();
		Query<User> query = ss.createQuery(queryString.toString());
		query.setParameter(1, name);
		query.setParameter(2, pass);
		return query.getResultList();
	}

}
