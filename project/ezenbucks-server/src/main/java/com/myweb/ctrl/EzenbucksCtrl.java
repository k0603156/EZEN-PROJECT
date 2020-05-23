package com.myweb.ctrl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.domain.CoffeeVO;
import com.myweb.service.CoffeeService;

@RestController
@RequestMapping(value = "/api/*", produces = "application/json")
public class EzenbucksCtrl {
	private static final Logger log = LoggerFactory.getLogger(EzenbucksCtrl.class);
	@Inject
	private CoffeeService csv;

	@GetMapping(value = "/coffeelist")
	public List<CoffeeVO> list() {
		List<CoffeeVO> coffeelist = csv.list();
		return coffeelist;
	}
	
//	@GetMapping(value = "/foodlist")
//	public List<CoffeeVO> list() {
//		List<CoffeeVO> foodlist = csv.list();
//		return food;
//	}
}
