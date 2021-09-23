package com.java.code.challenge.storage;

import java.util.List;

import com.java.code.challenge.entity.Product;

public interface Storage<T> {

	void add(T element);
	List<T> list();
	T get(Long id);
	void refresh(Product productBO);

}
