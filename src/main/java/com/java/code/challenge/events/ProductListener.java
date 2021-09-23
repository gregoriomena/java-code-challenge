package com.java.code.challenge.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.java.code.challenge.dto.ProductDTO;
import com.java.code.challenge.service.ProductService;

@Component
public class ProductListener {

	private ProductService service;

	@Autowired
	public ProductListener(ProductService service) {
		this.service = service;
	}

	@EventListener
	public void save(ProductDTO product) {
		service.save(product);
	}
}
