package com.java.code.challenge.integration.events;

import static com.java.code.challenge.util.ProductUtil.generateRandomLetters;
import static org.awaitility.Awaitility.await;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.code.challenge.events.ProductPublisher;
import com.java.code.challenge.service.ProductService;

@SpringBootTest()
class ProductListenerTest {

	@Autowired
	private ProductPublisher productPublisher;

	@Autowired
	private ProductService productService;

	@Test
	void testProductEvents() throws InterruptedException {

		int productsCountPre = productService.findAll().size();

		productPublisher.publish(1L, generateRandomLetters(5), generateRandomLetters(150));
		productPublisher.publish(2L, generateRandomLetters(5), generateRandomLetters(150));
		productPublisher.publish(3L, generateRandomLetters(5), generateRandomLetters(150));

		await().atMost(5, TimeUnit.SECONDS).until(didTheThing(productsCountPre));
	}

	private Callable<Boolean> didTheThing(int productsCountPre) {
		return new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				return productService.findAll().size() - 3 == productsCountPre;
			}
		};
	}

}