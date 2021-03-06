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
		// l???y d??? li???u t??? data ( truy v???n sql) 
		List<UserProduct_DTO> listUP = userProduct_DTO.convertDTO(userProductService.getAll());
		
		// Arr Rate
		int numberUser = userService.getAllCategory().size()+1;
		int numberProduct = productService.getProduct().size()+1;
		
		
		// KH???I T???O M???NG D??? LI???U
		double arr[][] = new double[numberUser][numberProduct];

		//  g??nh d??? li???u t??? sql v??o m???ng
		for (UserProduct_DTO userProduct_DTO : listUP) {
			arr[userProduct_DTO.getUser_id()][userProduct_DTO.getProduct_id()] = userProduct_DTO.getRate();
		}
		// i l?? user th??? i
		// j l?? product th??? j
		// t???o ra 1 m???ng ????? l??u kho???ng c??ch g???n nh???t c???a user c???n d??? ??o??n v?? c??c user 
		List<Pair<Integer, Double>> listPair = new ArrayList<Pair<Integer, Double>>();
		
		
		// (xa-xb)^2
		// l??c m?? e ????ng nh???p user th??? n s??? c?? id 
		int index = 1;
		for(int i = 1 ;i<numberUser;i++) {
			double tmpKNN = 0;
			for(int j =1;j<numberProduct;j++) {
				// D???a v??o c??ng th???c euclid t??nh kho???ng c??ch c???a user c?? id l?? id v???i t???ng user sau ???? t???ng (+=) l???i  
				tmpKNN += (arr[id][j]-arr[i][j])*(arr[id][j]-arr[i][j]);
			}
			// c??i n??y a vi???t h??i l???ng nh???ng. ????? ????nh ch??? s??? sau n??y cho d??? t??nh to??n
			// c??c e c?? th??? t??m hi???u pair<key,value> c???a java nh?? 
			// t???o 1 pair ????? l??u user th??? i v?? gi?? tr??? kho???ng c??ch c???a user ???? v???i user th??? i 
			// hashmap n?? l?? 1 danh s??ch g???m c??ch gi?? tr??? v???i t???ng ph???n t??? g???m key value do m??nh c?? th??? ?????nh ngh??a 
			// pair n?? ch??? l?? 1 ph???n t??? c?? key v?? value do m??nh ?????nh ngh??a 
			// th??? d??ng hash map thay cho list v?? pair xem !!!
			Pair<Integer, Double> pair = new Pair<Integer,Double>(index, Math.sqrt(tmpKNN));
			listPair.add(pair);
			index++;
			
		}
		// c??i n??y l?? sort l???i c??i list pair ????? t??nh ra k th???ng g???n nh???t 
		Collections.sort(listPair, new Comparator<Pair<Integer, Double>>() {
			@Override
			public int compare(Pair<Integer, Double> pair1,Pair<Integer, Double> pair2) {
				return pair1.right > pair2.right ? 1 : -1;
			}
		});
		// l???y ra k=12 s???n ph???m c?? kho???ng c??ch b?? nh???t 
		int KNN[] = new int[12];
		for(int i = 0 ;i<listPair.size();i++) {
			if(i<12) {
				KNN[i]=listPair.get(i).left;
			}
		}
		
		// m??nh c???n 1 m???ng m???i ????? l??u d??? li???u s???p x???p d??? ??o??n ch??nh x??c nh???t c???a s???n ph???m d???a v??o 12 s???n ph???m n??y 
		// th??? d??ng hashmap xem !!
		List<Pair<Integer, Double>> listPair1 = new ArrayList<Pair<Integer, Double>>();
		
		
		double KNN1[] = new double[numberProduct];
		KNN1[0]=0;
		int index1 = 1;
		// duy???t s???n ph???m ????? t??nh ra c??c gi?? tr??? trung b??nh t????ng t???ng 
		for(int i = 1;i<numberProduct;i++) {
			double tmp = 0;
			int cnt = 0;
			if (arr[id][i]==0) {
				for(int j = 0;j<12;j++) {
					
					// t??nh t???ng ????? ????nh gi?? c???a t???ng user v???i t???ng s???n ph???m nh??ng ph???i > 0
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
			// tr?????ng h???p t???t c??? ?????u ch??a ???????c ????nh gi?? ( t???c = 0) th?? add 0 
			
		}
		// ph??a d?????i ch??? l?? s???p x???p v?? ????a ra s???n ph???m n??o th??i 
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
