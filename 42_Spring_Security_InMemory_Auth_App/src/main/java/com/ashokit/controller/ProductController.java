package com.ashokit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.dto.Product;

@RestController
@RequestMapping("/v1/api/products")
public class ProductController {
	
	@GetMapping("/")
	public ResponseEntity<?> getAllProductsInformation(){
		return new ResponseEntity<List<Product>>(getAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<?> getProductInformationId(@PathVariable("productId") String productId){
		Optional<Product> findAny = getAllProducts().stream().filter(product -> productId.equals(product.getProductId())).findAny();
		return new ResponseEntity<Product>(findAny.get(),HttpStatus.OK);
	}
	
	@GetMapping("/version")
	public String getProductVersion() {
		return "Product Version :::: v10.6";
	}
	
	private List<Product> getAllProducts(){
		Product product1  = new Product("AIT123","Computer",25000.00d);
		Product product2  = new Product("AIT124","MobilPhone",35000.00d);
		return List.of(product1,product2);
	}
	
	
}
