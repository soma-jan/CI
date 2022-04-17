package com.revature.Track2gether.repositories;

import com.revature.Track2gether.model.Transactiontype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<Transactiontype,Integer> {

}

