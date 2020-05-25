package com.myweb.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myweb.domain.ItemVO;
import com.myweb.domain.OrderDetailReq;
import com.myweb.domain.OrderReq;
import com.myweb.domain.OrderVO;
import com.myweb.domain.StoreMapVO;
import com.myweb.service.ItemService;
import com.myweb.service.MapService;
import com.myweb.service.OrderService;

@RestController
@RequestMapping(value = "/api/*", produces = "application/json")
public class EzenbucksCtrl {
	private static final Logger log = LoggerFactory.getLogger(EzenbucksCtrl.class);
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private MapService mapService;
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/item")
	public List<ItemVO> itemlist() {
		List<ItemVO> itemlist = itemService.list();
		return itemlist;
	}
	
	@GetMapping(value = "/shop")
	public List<StoreMapVO> storeMapList(@RequestParam("x") String x, @RequestParam("y") String y) {
		return mapService.arroundStore(x, y);
	}
	
	@PostMapping(value = "/order" )
	public void order(@RequestBody OrderReq order) throws Exception {
		orderService.saveOrder(OrderVO.newOrder(order.getOrderTotalPrice(), order.getShopId()), order.getOrderDetailReq());
	}

}
