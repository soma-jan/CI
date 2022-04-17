package com.revature.Track2gether.service;


import com.revature.Track2gether.dto.Categorydto;
import com.revature.Track2gether.dto.Transactiondto;
import com.revature.Track2gether.exception.BadParameterException;
import com.revature.Track2gether.model.Category;
import com.revature.Track2gether.model.Transaction;
import com.revature.Track2gether.model.Users;
import com.revature.Track2gether.repositories.CategoryRepository;
import com.revature.Track2gether.repositories.TransactionRepository;
import com.revature.Track2gether.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImp implements TransactionService {
    @Autowired
    private TransactionRepository transactionrepo;
    @Autowired
    private UsersRepository userrepo;
    @Autowired
    private CategoryRepository catrepo;

    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");


    public Transactiondto convertTransentitytoDTO(Transaction t){
        Transactiondto dto = new Transactiondto();
        dto.setId(t.getId());
        dto.setAmount(t.getAmount());
        dto.setDate((df.format(t.getDate())).toString());
        dto.setDescription(t.getDescription());
        dto.setCategoryid(t.getCategory().getId());
        dto.setCategoryname(t.getCategory().getCategoryname());
        dto.setCategoryType(t.getCategory().getTranstype().getType());
        dto.setUserid(t.getUser().getId());
        dto.setFirstname(t.getUser().getFirstname());
        dto.setLastname(t.getUser().getLastname());
        dto.setEmail(t.getUser().getEmail());
        dto.setShared(t.isShared());
        return dto;

    }






    @Override
    public Transactiondto addTransaction(Transaction t) throws BadParameterException {
        if(t.getAmount()<=0)
        {
            throw new BadParameterException("Enter a valid amount");
        }if(t.getDate()==null)
        {
            throw new BadParameterException("Enter a valid date");
        }
        Transaction  newtransaction = transactionrepo.save(t);
        Transactiondto dt =new Transactiondto();
        dt= convertTransentitytoDTO(newtransaction);
        return dt;

    }

    public List<Transactiondto> findByUser(Users user) {
        List<Transaction> t = transactionrepo.findByUser(user);
        List<Transactiondto> responses = new ArrayList<Transactiondto>();
        for (Transaction trans : t) {
            responses.add(convertTransentitytoDTO(trans));
        }
        return responses;
    }

    @Override
    public List<Transactiondto> findByTransactiontype(Users user ,int transtype) throws BadParameterException {
        if(transtype!=1 && transtype!=2)
        {
            throw new BadParameterException("Enter a valid Transaction type");
        }
        List<Transaction> t= transactionrepo.findByTransactiontype( user ,transtype);
        List<Transactiondto> responses = new ArrayList<Transactiondto>();
        for (Transaction trans : t) {
            responses.add(convertTransentitytoDTO(trans));
        }
        return responses;
    }

    @Override
    public List<Transactiondto> findByTransactions(int year, int month, Users user) {
        List<Transaction> t =  transactionrepo.findByTransactions(year, month, user);
        List<Transactiondto> responses = new ArrayList<Transactiondto>();
        for (Transaction trans : t) {
            responses.add(convertTransentitytoDTO(trans));
        }
        return responses;
    }

    @Override
    public Transactiondto updateTransaction(Transaction t) throws BadParameterException {
        if(t.getAmount()<=0)
        {
            throw new BadParameterException("Enter a valid amount");
        }if(t.getDate()==null)
        {
            throw new BadParameterException("Enter a valid date");
        }

        Transaction targetTrans = transactionrepo.findById(t.getId()).get();
        targetTrans.setAmount(t.getAmount());
        targetTrans.setDate(t.getDate());
        targetTrans.setDescription(t.getDescription());
        targetTrans.setCategory(t.getCategory());
        targetTrans.setShared(t.isShared());
        //transactionrepo.save(targetTrans);
        Transaction  updatedtrans = transactionrepo.save(targetTrans);
        Transactiondto dt =new Transactiondto();
        dt= convertTransentitytoDTO(updatedtrans);
        return dt;

    }



    @Override
    public void deleteTransactionById(int id) {
        Transaction targetTrans = transactionrepo.getById(id);
        transactionrepo.delete(targetTrans);

    }

    @Override
    public List<Categorydto> findByCategoryBytranstype(int transtype) {
        List<Category> getCategory=catrepo.findByCategoryBytranstype(transtype);
        List<Categorydto> responses = new ArrayList<Categorydto>();
        for (Category c : getCategory) {
            Categorydto cdto = new Categorydto();
            cdto.setId(c.getId());
            cdto.setCategoryname(c.getCategoryname());
            responses.add(cdto);
        }
        return responses;
    }

}

