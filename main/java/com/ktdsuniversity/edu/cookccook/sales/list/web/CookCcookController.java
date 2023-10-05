package com.ktdsuniversity.edu.cookccook.sales.list.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookCcookController {
	
	@GetMapping("/shop/main")
	public String viewShopingListPage() {
		return "cookccook/shoplistmain";

	}
	
	@GetMapping("/shop/main/productdetail")
	public String viewShopingProductDetailPage() {
		return "cookccook/productdetail";
	}
}
