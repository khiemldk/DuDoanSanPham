package com.DuDoanSanPham.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

	@GetMapping("/user1")
	public String test() {
		return "AAA";
	}
}
