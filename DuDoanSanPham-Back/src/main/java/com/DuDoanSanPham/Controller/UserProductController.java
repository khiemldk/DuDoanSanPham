package com.DuDoanSanPham.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DuDoanSanPham.DTO.ProductDTO;
import com.DuDoanSanPham.DTO.ProductModel;
import com.DuDoanSanPham.DTO.UserProduct_DTO;
import com.DuDoanSanPham.Entity.Product;
import com.DuDoanSanPham.Entity.User_Product;
import com.DuDoanSanPham.Service.ProductService;
import com.DuDoanSanPham.Service.UserProductService;
import com.DuDoanSanPham.Service.UserService;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserProductController {

	@Autowired
	private UserProductService userProductService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserProduct_DTO userProduct_DTO;
	@Autowired
	private ProductDTO productDTO;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/user/product")
	public List<UserProduct_DTO> getList(){
		System.out.print(1);
		return userProduct_DTO.convertDTO(userProductService.getAll());
	}
	@GetMapping("/user/product/{id}")
	public List<UserProduct_DTO> findByProperty(@PathVariable("id") int id) {
		return userProduct_DTO.convertDTO(userProductService.getListFromProp("id", id));
	}

	@GetMapping("/userPr/filter/{id}")
	public List<ProductDTO> getFilterUserProduct(@PathVariable("id") int id){
		int res[] = handle(id);
		
//		List<ProductDTO> listProductDTO = productDTO.convertDTO(productService.getProduct());
//		List<ProductDTO> ans = new ArrayList<ProductDTO>();
//		for(int i = 0;i<12;i++) {
//			System.out.println(res[i]);
//			for (ProductDTO productDTO : listProductDTO) {
//				if (res[i]==productDTO.getId()) {
//					ans.add(productDTO);
//					break;
//				}		
//			}
//		}
		List<ProductDTO> ans = new ArrayList<ProductDTO>();
		for(int i=0;i<12;i++) {
			System.out.println(i);
			if (productService.findById(res[i]) != null) {
				ProductDTO pro = productDTO.convertElement(productService.findById(res[i]));
				ans.add(pro);
			}
		}
		System.out.println(ans.size() + "ans");
		return ans;
	}
	
	@PostMapping("/user/product/update")
	public JSONObject updateUserProduct(@RequestBody UserProduct_DTO userProduct_DTO) {
		userProductService.updateUserProduct(userProduct_DTO);
		JSONObject json = new JSONObject();
		json.put("message", true);
		return json;
	}
	@PostMapping("/user/product/insert")
	public JSONObject saveUserProduct(@RequestBody UserProduct_DTO userProduct_DTO) {
		userProductService.InsertUserProduct(userProduct_DTO);
		JSONObject json = new JSONObject();
		json.put("message", true);
		return json;
	}
	@PostMapping("/findUserProduct")
	public List<ProductModel> getUserProduct(@RequestBody UserProduct_DTO userProduct_DTO){
		return userProductService.getUserProduct(userProduct_DTO.getUser_id(), userProduct_DTO.getProduct_id());
	}
	
	public int[] handle(int id) {
		// lấy dữ liệu từ data ( truy vấn sql) 
		List<UserProduct_DTO> listUP = userProduct_DTO.convertDTO(userProductService.getAll());
		
		// Arr Rate
		int numberUser = userService.getAllCategory().size()+1;
		int numberProduct = productService.getProduct().size()+1;
		
		
		// KHỞI TẠO MẢNG DỮ LIỆU
		double arr[][] = new double[numberUser][numberProduct];

		//  gánh dữ liệu từ sql vào mảng
		for (UserProduct_DTO userProduct_DTO : listUP) {
			arr[userProduct_DTO.getUser_id()][userProduct_DTO.getProduct_id()] = userProduct_DTO.getRate();
		}
		// i là user thứ i
		// j là product thứ j
		// tạo ra 1 mảng để lưu khoảng cách gần nhất của user cần dự đoán và các user 
		List<Pair<Integer, Double>> listPair = new ArrayList<Pair<Integer, Double>>();
		
		
		// (xa-xb)^2
		// lúc mà e đăng nhập user thứ n sẽ có id 
		int index = 1;
		for(int i = 1 ;i<numberUser;i++) {
			double tmpKNN = 0;
			for(int j =1;j<numberProduct;j++) {
				// Dựa vào công thức euclid tính khoảng cách của user có id là id với từng user sau đó tổng (+=) lại  
				tmpKNN += (arr[id][j]-arr[i][j])*(arr[id][j]-arr[i][j]);
			}
			// cái này a viết hơi lằng nhằng. để đánh chỉ số sau này cho dễ tính toán
			// các e có thể tìm hiểu pair<key,value> của java nhé 
			// tạo 1 pair để lưu user thứ i và giá trị khoảng cách của user đó với user thứ i 
			// hashmap nó là 1 danh sách gồm cách giá trị với từng phần tử gồm key value do mình có thể định nghĩa 
			// pair nó chỉ là 1 phần tử có key và value do mình định nghĩa 
			// thử dùng hash map thay cho list và pair xem !!!
			Pair<Integer, Double> pair = new Pair<Integer,Double>(index, Math.sqrt(tmpKNN));
			listPair.add(pair);
			index++;
			
		}
		// cái này là sort lại cái list pair để tính ra k thằng gần nhất 
		Collections.sort(listPair, new Comparator<Pair<Integer, Double>>() {
			@Override
			public int compare(Pair<Integer, Double> pair1,Pair<Integer, Double> pair2) {
				return pair1.right > pair2.right ? 1 : -1;
			}
		});
		// lấy ra k=12 sản phẩm có khoảng cách bé nhất 
		int KNN[] = new int[12];
		for(int i = 0 ;i<listPair.size();i++) {
			if(i<12) {
				KNN[i]=listPair.get(i).left;
			}
		}
		
		// mình cần 1 mảng mới để lưu dữ liệu sắp xếp dự đoán chính xác nhất của sản phẩm dựa vào 12 sản phẩm này 
		// thử dùng hashmap xem !!
		List<Pair<Integer, Double>> listPair1 = new ArrayList<Pair<Integer, Double>>();
		
		
		double KNN1[] = new double[numberProduct];
		KNN1[0]=0;
		int index1 = 1;
		// duyệt sản phẩm để tính ra các giá trị trung bình tương tứng 
		for(int i = 1;i<numberProduct;i++) {
			double tmp = 0;
			int cnt = 0;
			if (arr[id][i]==0) {
				for(int j = 0;j<12;j++) {
					
					// tính tổng độ đánh giá của từng user với từng sản phẩm nhưng phải > 0
					if (arr[KNN[j]][i]> 0) {
						tmp += arr[KNN[j]][i];
						cnt++;
					}
				}
				KNN1[index1] = (cnt !=0 ? tmp/cnt : 0);
				Pair<Integer, Double> pair = new Pair<Integer,Double>(i, KNN1[index1]);
				index1++;
				listPair1.add(pair);
			}
			// trường hợp tất cả đều chưa được đánh giá ( tức = 0) thì add 0 
			
		}
		// phía dưới chỉ là sắp xếp và đưa ra sản phẩm nào thôi 
		Collections.sort(listPair1, new Comparator<Pair<Integer, Double>>() {
			@Override
			public int compare(Pair<Integer, Double> pair1,Pair<Integer, Double> pair2) {
				return pair1.right > pair2.right ? 1 : -1;
			}
		});
		int res[] = new int[12];
		int ii = 0;
		for (int i = listPair1.size()-1;i>=0;i--) {
			res[ii]= listPair1.get(i).left;
			ii++;
			if (ii==12)
				break;
//			System.out.println(listPair1.get(i).left + " "+ listPair1.get(i).right);
		}
		Arrays.sort(KNN1);
//		for(int i = 0;i<12;i++) {
//			System.out.println(res[i] +  " ");
//		}
		Collections.sort(listUP,new Comparator<UserProduct_DTO>() {
			@Override
			public int compare(UserProduct_DTO o1, UserProduct_DTO o2) {
                return o1.getKnn() > o2.getKnn() ? 1 : -1;
            }
		});
		return res;
	}
	
}
