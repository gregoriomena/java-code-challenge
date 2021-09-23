package com.java.code.challenge.repository;

import static com.java.code.challenge.util.ProductUtil.generateRandomLetters;
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
}
