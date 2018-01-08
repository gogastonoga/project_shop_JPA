package com.capgemini.dao;

import java.util.List;
import java.util.Map;

import com.capgemini.domain.ClientEntity;
import com.capgemini.domain.ProductEntity;
import com.querydsl.core.Tuple;

public interface ProductDao extends Dao<ProductEntity, Long> {

	List<Long> uniqueBoughtProductsOfClient(Long clientId);
	List<Long> findTenTheBestOfProducts();
	Map<String,Integer>findProductsInProgress();
	
}
