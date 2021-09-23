package com.java.code.challenge.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = -2246714429379111704L;

	private Long id;
	private String name;
	private String description;

}
