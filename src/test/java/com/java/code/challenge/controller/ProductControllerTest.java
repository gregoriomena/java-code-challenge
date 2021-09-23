package com.java.code.challenge.controller;

import static com.java.code.challenge.util.ProductUtil.generateRandomLetters;
import static com.java.code.challenge.util.ProductUtil.randomProductDTO;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.java.code.challenge.dto.ProductDTO;
import com.java.code.challenge.service.ProductService;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

	@Test
	void save(@Mock ProductService service) {

		long productId = new Date().getTime();
		String productName = generateRandomLetters(5);
		String productDescription = generateRandomLetters(150);

		ProductDTO productDTO = new ProductDTO(productId, productName, productDescription);

		ProductController controller = new ProductController(service);
		controller.save(productDTO);

		verify(service).save(productDTO);
		verifyNoMoreInteractions(service);
	}

	@Test
	void read(@Mock ProductService service) {

		ProductController controller = new ProductController(service);
		controller.read();

		verify(service).findAll();
		verifyNoMoreInteractions(service);
	}


	@Test
	void update(@Mock ProductService service) {

		ProductDTO productDTO = randomProductDTO();

		ProductController controller = new ProductController(service);
		controller.update(productDTO);

		verify(service).update(productDTO);
		verifyNoMoreInteractions(service);
	}

	@Test
	void delete(@Mock ProductService service) {


		long productId = new Date().getTime();
		ProductController controller = new ProductController(service);

		controller.delete(productId);

		verify(service).delete(productId);
		verifyNoMoreInteractions(service);
	}

	@Test
	void search(@Mock ProductService service) {


		ProductController controller = new ProductController(service);

		controller.search(-1, "", "");

		verify(service).search(-1, "", "");
		verifyNoMoreInteractions(service);
	}
}

