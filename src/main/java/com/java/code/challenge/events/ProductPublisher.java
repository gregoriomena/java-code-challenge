package com.java.code.challenge.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.java.code.challenge.dto.ProductDTO;

@Component
public class ProductPublisher {

	private final ApplicationEventPublisher publisher;

	public ProductPublisher(ApplicationEventPublisher publisher){
		this.publisher = publisher;
	}

	@Async
	public void publish(Long id, String name, String description){
		publisher.publishEvent(new ProductDTO(id, name, description));
	}
}
