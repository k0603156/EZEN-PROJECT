package com.myweb.ctrl;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myweb.domain.ProductVO;
import com.myweb.service.ProductService;
import com.myweb.domain.OrderVO;
import com.myweb.service.OrderService;
import com.myweb.domain.CartVO;
import com.myweb.service.CartService;
import com.myweb.domain.ShopVO;
import com.myweb.service.ShopService;

@RestController
@RequestMapping(value = "/api/*", produces = "application/json")
public class EzenbucksCtrl {
	private static final Logger log = LoggerFactory.getLogger(EzenbucksCtrl.class);
	@Inject
	private ProductService productsv;
	@Inject
	private OrderService ordersv;
	@Inject
	private CartService cartsv;
	@Inject
	private ShopService shopsv;

	@GetMapping(value = "/productlist")
	public List<ProductVO> productlist() {
		List<ProductVO> productlist = productsv.list();
		return productlist;
	}
	
	@GetMapping(value="/cartlist")
	public List<CartVO> cartlist(){
		List<CartVO> cartlist = cartsv.list();
		return cartlist;
	}
	
	@GetMapping(value="/shoplist")
	public List<ShopVO> shoplist(){
		List<ShopVO> shoplist = shopsv.list();
		return shoplist;
	}
	
	@GetMapping(value="/orderlist")
	public List<OrderVO> orderlist(){
		List<OrderVO> orderlist = ordersv.list();
		return orderlist;
	}
}
