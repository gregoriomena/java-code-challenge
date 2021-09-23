package com.java.code.challenge.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.code.challenge.dto.ProductDTO;
import com.java.code.challenge.dto.mapper.ProductMapper;
import com.java.code.challenge.entity.Product;
import com.java.code.challenge.repository.ProductDao;

@Service
public class ProductService {

	private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);
	private ProductDao dao;


	@Autowired
	public ProductService(ProductDao dao) {
		this.dao = dao;
	}

	public void save(ProductDTO product) {

		Product productBO = mapper.destinationToSource(product);
		dao.save(productBO);
	}
}
