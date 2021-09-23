package com.java.code.challenge.storage;

import java.util.List;

public interface Storage<T> {

	void add(T element);
	List<T> list();

}
