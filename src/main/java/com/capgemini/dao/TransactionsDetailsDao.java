package com.capgemini.dao;


import java.sql.Date;
import java.util.List;

import com.capgemini.domain.TransactionsDetailsEntity;
import com.querydsl.core.Tuple;


public interface TransactionsDetailsDao extends Dao<TransactionsDetailsEntity, Long> {

	int countWholePrice(Long transactionId);
	List<Long> getThreeClientsWithMostAmountMoney(Date firstDate, Date secondDate);
	int getProfitOnDate(Date firstDate, Date secondDate);
	
}
