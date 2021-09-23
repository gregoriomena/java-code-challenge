package com.java.code.challenge.storage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.java.code.challenge.entity.Product;

@Component
public class ProductList implements Storage<Product> {

	private Map<Long, Product> products;

	public ProductList() {
		products = new LinkedHashMap<>();
	}

	@Override
	public void add(Product element) {
		products.put(element.getId(), element);
	}

	@Override
	public List<Product> list() {
		return new ArrayList<>(products.values());
	}

	@Override
	public Product get(Long id) {
		Product original = products.get(id);
		return new Product(original.getId(), original.getName(), original.getDescription());
	}

	@Override
	public void refresh(Product productBO) {
		products.put(productBO.getId(), productBO);
	}

}
