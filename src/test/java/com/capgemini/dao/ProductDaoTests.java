package com.capgemini.dao;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductDaoTests {

	@Autowired
	ProductDao productDao;

	@Test
	public void shouldTestReturnTheBestOfProducts() {

		// given
		List<Long> listExpected = Arrays.asList(50L, 11L, 17L, 29L, 24L, 41L, 39L, 5L, 14L, 18L);
		// when
		List<Long> resultList = productDao.findTenTheBestOfProducts();
		// then
		assertEquals(10, resultList.size());
		assertTrue(resultList.equals(listExpected));

	}

	@Test
	public void shouldTestReturnProductsInProgress() {

		// when
		Map<String, Integer> result = productDao.findProductsInProgress();
		// then
		assertEquals(30, result.size());
	}

	@Test
	public void shouldTestReturnUniqueBoughtProductsOfClient() {

		List<Long> resultList = productDao.uniqueBoughtProductsOfClient(1L);
		assertEquals(12, resultList.size());

	}

}
