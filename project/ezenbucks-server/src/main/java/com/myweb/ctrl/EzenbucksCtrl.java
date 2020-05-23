package com.myweb.ctrl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.domain.CoffeeVO;
import com.myweb.service.CoffeeService;
import com.myweb.domain.FoodVO;
import com.myweb.domain.OrderVO;
import com.myweb.service.FoodService;
import com.myweb.service.OrderService;

@RestController
@RequestMapping(value = "/api/*", produces = "application/json")
public class EzenbucksCtrl {
	private static final Logger log = LoggerFactory.getLogger(EzenbucksCtrl.class);
	@Inject
	private CoffeeService csv;
	
	@Inject
	private FoodService fsv;
	
	@Inject
	private OrderService osv;

	@GetMapping(value = "/coffeelist")
	public List<CoffeeVO> coffeelist() {
		List<CoffeeVO> coffeelist = csv.list();
		return coffeelist;
	}
	
	@GetMapping(value = "/foodlist")
	public List<FoodVO> foodlist() {
		List<FoodVO> foodlist = fsv.list();
		return foodlist;
	}
	
	@GetMapping(value="/orderlist")
	public List<OrderVO> orderlist(){
		List<OrderVO> orderlist = osv.list();
		return orderlist;
	}
}
