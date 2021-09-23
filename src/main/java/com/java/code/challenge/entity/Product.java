package com.java.code.challenge.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Product implements Serializable {

	private static final long serialVersionUID = -4692633228301195654L;

	private Long id;
	private String name;
	private String description;

}
