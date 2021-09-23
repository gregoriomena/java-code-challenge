package com.java.code.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.code.challenge.dto.ProductDTO;
import com.java.code.challenge.service.ProductService;

@RestController()
@RequestMapping("/products")
public class ProductController {

	private ProductService service;

	@Autowired
	public ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@RequestBody ProductDTO product) {
		service.save(product);
	}
}

