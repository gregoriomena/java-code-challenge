package com.java.code.challenge.util;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

import com.java.code.challenge.dto.ProductDTO;
import com.java.code.challenge.entity.Product;

public class ProductUtil {

	public static String generateRandomLetters(int length) {
		return RandomStringUtils.random(length, true, false);
	}

	public static Product randomProductBO() {

		long productId = new Date().getTime();
		String productName = generateRandomLetters(5);
		String productDescription = generateRandomLetters(150);

		Product product = new Product(productId, productName, productDescription);
		return product;
	}

	public static ProductDTO randomProductDTO() {

		long productId = new Date().getTime();
		String productName = generateRandomLetters(5);
		String productDescription = generateRandomLetters(150);

		ProductDTO productDTO = new ProductDTO(productId, productName, productDescription);
		return productDTO;
	}
}
