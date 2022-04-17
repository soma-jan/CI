package com.revature.Track2gether.repositories;

import com.revature.Track2gether.model.Category;
import com.revature.Track2gether.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query("select c from Category c  join  Transactiontype tt on c.transtype =tt.id and tt.id=?1")
    public List<Category> findByCategoryBytranstype(int transtype);

}
