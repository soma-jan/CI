package com.revature.Track2gether.service;

import com.revature.Track2gether.dto.Categorydto;
import com.revature.Track2gether.dto.Transactiondto;
import com.revature.Track2gether.exception.BadParameterException;
import com.revature.Track2gether.model.Category;
import com.revature.Track2gether.model.Transaction;
import com.revature.Track2gether.model.Users;

import java.util.List;

public interface TransactionService {
    public Transactiondto addTransaction(Transaction t) throws BadParameterException;

    public List<Transactiondto> findByUser(Users user);

    public List<Transactiondto> findByTransactiontype(Users user,int transtype) throws BadParameterException;

    public List<Transactiondto> findByTransactions(int year,int month, Users user);


    public Transactiondto updateTransaction(Transaction transaction) throws BadParameterException;

    public List<Categorydto> findByCategoryBytranstype(int transtype);

    public void deleteTransactionById(int id);
}