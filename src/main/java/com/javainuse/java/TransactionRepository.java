package com.javainuse.java;

import org.springframework.data.repository.CrudRepository;

import com.javainuse.entity.Transaction;


public interface TransactionRepository extends CrudRepository<Transaction, Integer>{

}
