package com.javainuse.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.entity.Transaction;



@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	public void addTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}
}
