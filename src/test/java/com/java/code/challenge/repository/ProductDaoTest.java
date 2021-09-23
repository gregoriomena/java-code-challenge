package com.java.code.challenge.repository;

import static com.java.code.challenge.util.ProductUtil.generateRandomLetters;
import static com.java.code.challenge.util.ProductUtil.randomProductBO;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.java.code.challenge.entity.Product;
import com.java.code.challenge.storage.Storage;

@ExtendWith(MockitoExtension.class)
class ProductDaoTest {

	@Test
	void save(@Mock Storage<Product> storage) {

		Product product = new Product(new Date().getTime(), generateRandomLetters(5), generateRandomLetters(150));

		ProductDao dao = new ProductDao(storage);
		dao.save(product);

		verify(storage).add(product);
		verifyNoMoreInteractions(storage);
	}

	@Test
	void read(@Mock Storage<Product> storage) {

		ProductDao dao = new ProductDao(storage);
		dao.findAll();

		verify(storage).list();
		verifyNoMoreInteractions(storage);
	}

	@Test
	void update(@Mock Storage<Product> storage) {

		Product product = randomProductBO();

		ProductDao dao = new ProductDao(storage);
		dao.update(product);

		verify(storage).refresh(product);
		verifyNoMoreInteractions(storage);
	}


	@Test
	void remove(@Mock Storage<Product> storage) {

		long productId = new Date().getTime();
		ProductDao dao = new ProductDao(storage);

		dao.delete(productId);

		verify(storage).remove(productId);
		verifyNoMoreInteractions(storage);
	}
}
