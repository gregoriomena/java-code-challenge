package com.java.code.challenge.service;

import java.util.List;
import java.util.stream.Collectors;

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

	public List<ProductDTO> findAll() {

		List<Product> products = dao.findAll();

		return products.stream().map(iterProduct -> mapper.sourceToDestination(iterProduct))
				.collect(Collectors.toList());
	}

	public void update(ProductDTO product) {
		Product productBO = mapper.destinationToSource(product);
		dao.update(productBO);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

	public List<ProductDTO> search(long id, String name, String description) {

		return dao.findAll().stream().filter(iterProduct -> checkFilter(iterProduct, id, name, description))
				.map(iterProduct -> mapper.sourceToDestination(iterProduct)).collect(Collectors.toList());
	}

	private boolean checkFilter(Product iterProduct, long id, String name, String description) {
		return (id < 0 || iterProduct.getId().equals(id))
				&& (name.isBlank() || iterProduct.getName().toLowerCase().contains(name.toLowerCase()))
				&& (description.isBlank()
						|| iterProduct.getDescription().toLowerCase().contains(description.toLowerCase()));
	}
}
