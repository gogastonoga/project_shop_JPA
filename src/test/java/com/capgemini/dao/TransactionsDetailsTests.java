package com.capgemini.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TransactionsDetailsTests {

	@Autowired
	TransactionsDetailsDao detailsDao;
	
	@Test
	public void testShouldCountWholePrice() {

		// when
		int wholeAmountA = detailsDao.countWholePrice(2L);
		int wholeAmountB = detailsDao.countWholePrice(3L);
		// then
		assertEquals(16695, wholeAmountA);
		assertEquals(212110, wholeAmountB);
	}
	
	@Test
	public void testShouldReturnThreeClientsWhoSpendMostAmountMoney() {

		//given
		String firstDate = "2017-01-05";
		String secondDate = "2017-12-01";
		//when
		List<Long> result = detailsDao.getThreeClientsWithMostAmountMoney(Date.valueOf(firstDate), Date.valueOf(secondDate));
		///then
		System.out.println(result);
        assertEquals(3, result.size());
        assertTrue(result.contains(6L));
        assertTrue(result.contains(9L));
        assertTrue(result.contains(13L));
        
	}
	
	@Test
	public void testShouldGetProfitOnDate(){
		
		//given
		String firstDate = "2017-01-05";
		String secondDate = "2017-12-01";
		//when
		int profit = detailsDao.getProfitOnDate(Date.valueOf(firstDate), Date.valueOf(secondDate));
		//then
		assertEquals(1899795, profit);
	}
}
