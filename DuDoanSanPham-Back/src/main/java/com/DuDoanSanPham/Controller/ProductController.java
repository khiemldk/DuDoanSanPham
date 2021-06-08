package com.DuDoanSanPham.Controller;

import java.util.ArrayList;
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
import com.DuDoanSanPham.Entity.User;
import com.DuDoanSanPham.Entity.Product;
import com.DuDoanSanPham.Service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {
	// tự động tìm productService để liên kết autowired
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDTO productDTO;
	
	@GetMapping("/product")
	public List<ProductDTO> getProducts(){
		return productDTO.convertDTO(productService.getProduct());
	}
	
	@GetMapping("product/{id}")
	public List<ProductDTO> findByProperty(@PathVariable("id") int id) {
		return productDTO.convertDTO(productService.getListFromProp("id", id));
	}
	@GetMapping("product/filter/{id}")
	public List<ProductDTO> getFilterProduct(@PathVariable("id") int id){
		return filterProduct(id);
	}
	
	@PostMapping("product/save") 
	public JSONObject saveProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		JSONObject json = new JSONObject();
		json.put("message", true);
		return json;
	}
	
	public List<ProductDTO> filterProduct( int id){
		ProductDTO pro= productDTO.convertDTO(productService.getListFromProp("id", id)).get(0);
		List<ProductDTO> listProDTO = productDTO.convertDTO(productService.getProduct());
		
		for (ProductDTO productDTO : listProDTO) {
			float tmpPrice = productDTO.getPrice()-pro.getPrice();
//			float tmpDiscount = productDTO.getDiscount()-pro.getDiscount();
//			float tmpRate = productDTO.getRate()-pro.getRate();
			float tmpSold = productDTO.getSold()-pro.getSold();
			float tmpNumberAcc = productDTO.getNumber_access()-pro.getNumber_access();
			
			double temp = Math.sqrt(tmpPrice*tmpPrice + tmpSold*tmpSold + tmpNumberAcc*tmpNumberAcc);
			
			productDTO.setKnn(temp);
		}
		
		Collections.sort(listProDTO,new Comparator<ProductDTO>() {
			@Override
			public int compare(ProductDTO o1, ProductDTO o2) {
                return o1.getKnn() > o2.getKnn() ? 1 : -1;
            }
		});
		
		
		
		return listProDTO;
	}
}
