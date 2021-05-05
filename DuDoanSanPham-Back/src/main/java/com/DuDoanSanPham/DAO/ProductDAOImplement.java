package com.DuDoanSanPham.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.DuDoanSanPham.Entity.Product;

@Repository
@Transactional(rollbackFor = Exception.class)
//  thằng này nó sẽ thừa kế từ thằng BaseDAOImplement(thằng base này là dùng chung) 
// và nó sẽ implement ProductDAO cái mà do nó tự định nghĩa nếu các em muốn thêm hàm nào chỉ riêng nó
public class ProductDAOImplement extends BaseDAOImplement<Product> implements ProductDAO<Product>{

}
