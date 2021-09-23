package com.java.code.challenge.service;

import static com.java.code.challenge.util.ProductUtil.generateRandomLetters;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.java.code.challenge.dto.ProductDTO;
import com.java.code.challenge.entity.Product;
import com.java.code.challenge.repository.ProductDao;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

	@Test
	void save(@Mock ProductDao dao) {

		long productId = new Date().getTime();
		String productName = generateRandomLetters(5);
		String productDescription = generateRandomLetters(150);

		Product productBO = new Product(productId, productName, productDescription);
		ProductDTO productDTO = new ProductDTO(productId, productName, productDescription);

		ProductService service = new ProductService(dao);
		service.save(productDTO);

		verify(dao).save(productBO);
		verifyNoMoreInteractions(dao);
	}

	@Test
	void read(@Mock  ProductDao dao) {

		ProductService service = new ProductService(dao);
		service.findAll();

		verify(dao).findAll();
		verifyNoMoreInteractions(dao);
	}


	@Test
	void update(@Mock ProductDao dao) {

		long productId = new Date().getTime();
		String productName = generateRandomLetters(5);
		String productDescription = generateRandomLetters(150);

		Product productBO = new Product(productId, productName, productDescription);
		ProductDTO productDTO = new ProductDTO(productId, productName, productDescription);

		ProductService service = new ProductService(dao);
		service.update(productDTO);

		verify(dao).update(productBO);
		verifyNoMoreInteractions(dao);
	}

	@Test
	void delete(@Mock ProductDao dao) {

		long productId = new Date().getTime();
		ProductService service = new ProductService(dao);

		service.delete(productId);

		verify(dao).delete(productId);
		verifyNoMoreInteractions(dao);
	}

	@Test
	void search(@Mock ProductDao dao) {


		Product productBike = new Product(new Date().getTime(), "Bike", "Small bike");
		Product productCamera = new Product(new Date().getTime(), "Camera", "Sony camera");
		List<Product> products = Arrays.asList(productBike, productCamera);

		when(dao.findAll()).thenReturn(products);

		ProductService service = new ProductService(dao);
		List<ProductDTO> searchResult = service.search(-1, "bik", "");

		assertFalse(searchResult.isEmpty());
		assertEquals(1, searchResult.size());
		assertEquals("Bike", searchResult.get(0).getName());

		searchResult = service.search(-1, "noesta", "");

		assertTrue(searchResult.isEmpty());

	}
}

