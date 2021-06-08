package com.DuDoanSanPham.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DuDoanSanPham.DTO.ProductModel;
import com.DuDoanSanPham.DTO.UserProduct_DTO;
import com.DuDoanSanPham.Entity.User;
import com.DuDoanSanPham.Entity.User_Product;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserProductDAOImplement extends BaseDAOImplement<User_Product> implements UserProductDAO<User_Product> {

	@Override
	public List<ProductModel> findUserProduct(int user_id, int product_id) {
		List<User_Product> u1 = new ArrayList<User_Product>();
		StringBuilder queryString = new StringBuilder("");
		queryString.append("select * from ").append("user_product").append(" as model where model.active_flag=1 and model.user_id")
			 .append("=?1").append(" and model.product_id").append("=?2");
//		System.out.println(queryString);
		Session ss = sessionFactory.getCurrentSession();
//		Query<?> query = ss.createQuery(queryString.toString());
		NativeQuery query = ss.createNativeQuery(queryString.toString());
		
		query.setParameter(1, user_id);
		query.setParameter(2, product_id);

		List<Map<String,ProductModel>> aliasToValueMapList=query.list();
		List<ProductModel> list =query.setResultTransformer( Transformers.aliasToBean( ProductModel.class ) ).list();
		
		return list;
	}

	@Override
	public void update(float rate,int id) {
		// TODO Auto-generated method stub
		StringBuilder queryString = new StringBuilder("");
		queryString.append("update user_product set rate=?1 where id=?2");
		Session ss = sessionFactory.getCurrentSession();
		NativeQuery query = ss.createNativeQuery(queryString.toString());
		query.setParameter(1, rate);
		query.setParameter(2, id);
		query.executeUpdate();
	}

	@Override
	public void insertUserProduct(float user_id, int product_id,float rate) {
		StringBuilder queryString = new StringBuilder("");
		queryString.append("insert into user_product(user_id,product_id,rate,active_flag,discount) ")
		.append("values(?1,?2,?3,1,0)");
		Session ss = sessionFactory.getCurrentSession();
		NativeQuery query = ss.createNativeQuery(queryString.toString());
		query.setParameter(1, user_id);
		query.setParameter(2, product_id);
		query.setParameter(3, rate);
		query.executeUpdate();
	}
	
	

}
