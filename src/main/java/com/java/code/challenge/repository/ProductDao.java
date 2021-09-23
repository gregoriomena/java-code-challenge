package com.java.code.challenge.repository;

import java.util.List;

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

	@Override
	public List<Product> findAll() {
		return products.list();
	}

	@Override
	public Product findById(Long id) {
		return products.get(id);
	}

	@Override
	public void update(Product productBO) {
		products.refresh(productBO);
	}


	@Override
	public void delete(Long id) {
		products.remove(id);
	}
}
