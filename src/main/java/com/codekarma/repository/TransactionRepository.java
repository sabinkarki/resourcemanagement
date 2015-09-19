package com.codekarma.repository;

import org.springframework.data.repository.CrudRepository;

import com.codekarma.domain.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
