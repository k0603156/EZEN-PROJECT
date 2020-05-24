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
import com.myweb.domain.ShopVO;
import com.myweb.service.ShopService;

@RestController
@RequestMapping(value = "/api/*", produces = "application/json")
public class EzenbucksCtrl {
	private static final Logger log = LoggerFactory.getLogger(EzenbucksCtrl.class);
	@Inject
	private ItemService itemsv;
	@Inject
	private OrderService ordersv;
	@Inject
	private ShopService shopsv;

	@GetMapping(value = "/item/list")
	public List<ItemVO> itemlist() {
		List<ItemVO> itemlist = itemsv.list();
		return itemlist;
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
}
