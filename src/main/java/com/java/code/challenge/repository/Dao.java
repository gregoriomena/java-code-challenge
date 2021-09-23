package com.java.code.challenge.repository;

import java.util.List;

public interface Dao<T> {

	void save(T entity);
	List<T> findAll();
}
