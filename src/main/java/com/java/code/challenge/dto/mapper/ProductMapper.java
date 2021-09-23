package com.java.code.challenge.dto.mapper;

import org.mapstruct.Mapper;

import com.java.code.challenge.dto.ProductDTO;
import com.java.code.challenge.entity.Product;

@Mapper
public interface ProductMapper {

	ProductDTO sourceToDestination(Product source);
	Product destinationToSource(ProductDTO destination);
}
