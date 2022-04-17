package com.revature.Track2gether.repositories;

import com.revature.Track2gether.model.Transaction;
import com.revature.Track2gether.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {


   @Query("select t from Transaction t  where t.user=?1 and  t.category  in(select c from Category c  join  Transactiontype tt on c.transtype =tt.id and tt.id=?2)")
   public List<Transaction> findByTransactiontype(Users user,int transtype);
   public List<Transaction> findByUser(Users user);
   @Query("select t from Transaction t where year(t.date)=?1 and month(t.date)=?2 and t.user=?3")
   public List<Transaction> findByTransactions(int year,int month,Users user);


}