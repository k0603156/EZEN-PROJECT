package com.myweb.ctrl;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myweb.domain.ItemVO;
import com.myweb.service.ItemService;
import com.myweb.domain.OrderVO;
import com.myweb.service.OrderService;
import com.myweb.domain.OrderDetailVO;
import com.myweb.service.OrderDetailService;
import com.myweb.domain.ShopVO;
import com.myweb.service.ShopService;
import com.myweb.domain.CartVO;
import com.myweb.service.CartService;

@RestController
@RequestMapping(value = "/api/*", produces = "application/json")
public class EzenbucksCtrl {
	private static final Logger log = LoggerFactory.getLogger(EzenbucksCtrl.class);
	@Inject
	private ItemService itemsv;
	@Inject
	private OrderService ordersv;
	@Inject
	private OrderDetailService orderdetailsv;
	@Inject
	private ShopService shopsv;
	@Inject
	private CartService cartsv;

	@GetMapping(value = "/item/list")
	public List<ItemVO> itemlist() {
		List<ItemVO> itemlist = itemsv.list();
		return itemlist;
	}
	
	@GetMapping(value="/cart/list")
	public List<CartVO> cartlist(){
		List<CartVO> cartlist = cartsv.list();
		return cartlist;
	}
	
	@GetMapping(value="/shop/list")
	public List<ShopVO> shoplist(){
		List<ShopVO> shoplist = shopsv.list();
		return shoplist;
	}
	
	@GetMapping(value="/order/list")
	public List<OrderVO> orderlist(){
		List<OrderVO> orderlist = ordersv.list();
		return orderlist;
	}
	
	@GetMapping(value="/order-detail")
	public List<OrderDetailVO> order_detail(){
		List<OrderDetailVO> orderdetail = orderdetailsv.list();
		return orderdetail;
	}
}
