package com.myweb.ctrl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.domain.ProductVO;
import com.myweb.service.OrderService;
import com.myweb.service.ProductService;
import com.myweb.service.ShopService;
import com.myweb.util.CustomParser;
import com.myweb.util.LocalAPIHelper;
import com.myweb.util.OptionID;

//order, receipt 湲곕뒫�� customer_id �븘�슂

@RestController
@RequestMapping(value = "/api/*", produces = "application/json")
public class ProductCtrl {
	private static final Logger log = LoggerFactory.getLogger(ProductCtrl.class);
	
	@Inject
	private ProductService psv;
	
	@Inject
	private ShopService scv;
	
	@Inject
	private OrderService osv;
	
	
	@GetMapping(value = "/product")
	public ResponseEntity<?> list(){
		return new ResponseEntity<>(psv.list(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/product/{product_id}")
	public ResponseEntity<?> detail(@PathVariable("product_id")int product_id){
		return new ResponseEntity<>(psv.detail(product_id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/shop")
	public ResponseEntity<?> shoplist(){
		return new ResponseEntity<>(scv.list(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/shop/{x}/{y}")
	public ResponseEntity<?> list(@PathVariable("x")double x,  @PathVariable("x")double y) throws Exception{
//		sample x, y: y = 37.5025398;x = 127.0226792 (ezen academy);
		int radius = 3000;
		int size = 3;
		List<Map<String, String>> list = CustomParser.getShopList(LocalAPIHelper.getSampleData("�뒪��踰낆뒪", x, y, radius, size));
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping(path = "/order", consumes = "application/json")
	public ResponseEntity<?> order(@RequestBody Map<String, Object> data) {
		//�궗�슜�옄 �븘�씠�뵒 �엫�쓽 �옉�꽦 
		int customer_id = 1; 
		//
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		List<Map<String, String>> productList = (List<Map<String, String>>)data.get("products");
		String shop_name = (String) data.get("shop_name");
		for(int i = 0; i < productList.size(); i++) {
			Map<String, String> map = new HashMap<String, String>();
			int option_id = OptionID.getOptionID(productList.get(i).get("opt_temp"), productList.get(i).get("opt_size"));
			map.put("product_id", String.valueOf(productList.get(i).get("product_id")));
			map.put("quantity", String.valueOf(productList.get(i).get("quantity")));
			map.put("product_opt_id", String.valueOf(option_id)); 
			list.add(map); 
		}
		
		osv.writeOrder(customer_id, list, shop_name); 
		return new ResponseEntity<>("sucess", HttpStatus.OK);
	}
	@GetMapping(value = "/receipt")
	public ResponseEntity<?> getReceipt() throws Exception{
		int customer_id = 1; 
		return new ResponseEntity<>(osv.getReceipt(customer_id), HttpStatus.OK);
	}
}