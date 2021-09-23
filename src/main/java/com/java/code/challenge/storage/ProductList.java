package com.java.code.challenge.storage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.java.code.challenge.entity.Product;

@Component
public class ProductList implements Storage<Product> {

	private List<Product> products;

	public ProductList() {
		products = new ArrayList<>();
	}

	@Override
	public void add(Product element) {
		products.add(element);
	}

}
