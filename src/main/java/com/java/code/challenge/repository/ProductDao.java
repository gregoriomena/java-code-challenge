package com.java.code.challenge.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.code.challenge.entity.Product;
import com.java.code.challenge.storage.Storage;

@Repository
public class ProductDao implements Dao<Product> {

	private Storage<Product> products;

	@Autowired
	public ProductDao(Storage<Product> products) {
		this.products = products;
	}

	@Override
	public void save(Product product) {
		products.add(product);
	}
}
