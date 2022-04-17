package com.revature.Track2gether.service;

import com.revature.Track2gether.dto.Transactiondto;
import com.revature.Track2gether.exception.BadParameterException;
import com.revature.Track2gether.model.Category;
import com.revature.Track2gether.model.Transaction;
import com.revature.Track2gether.model.Transactiontype;
import com.revature.Track2gether.model.Users;
import com.revature.Track2gether.repositories.TransactionRepository;
import com.revature.Track2gether.repositories.UsersRepository;
import io.jsonwebtoken.lang.Assert;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import javax.security.auth.login.FailedLoginException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import java.util.Optional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImpTest {
    @Mock
    private TransactionRepository transrepo;


    @InjectMocks
    private TransactionServiceImp transserviceImp;

    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    Users fakeuser = new Users();
    Category fakecat = new Category();
    Transaction faketransaction = new Transaction();
    Transactiondto fakedto = new Transactiondto();
    List<Transaction> fakeTransactions = new ArrayList<>();
    List<Transactiondto> fakeTransDto = new ArrayList<>();

    @BeforeEach
    public void setup() throws ParseException {
        // Users fakeuser = new Users();
        fakeuser.setId(1);
        fakeuser.setFirstname("lixy");
        fakeuser.setLastname("mat");
        fakeuser.setEmail("abc.j8@gmail.com");
        fakeuser.setPassword("lixy123");

        // Category fakecat = new Category();

        fakecat.setId(6);
        fakecat.setCategoryname("food");
        fakecat.setTranstype(new Transactiontype(6, "expenses"));



        //  Transaction faketransaction = new Transaction();

        faketransaction.setId(1);
        faketransaction.setDate(df.parse("12/12/2022"));
        faketransaction.setAmount(2000);
        faketransaction.setDescription("expense added");
        faketransaction.setShared(true);
        faketransaction.setUser(fakeuser);
        faketransaction.setCategory(fakecat);

        // Transactiondto fakedto = new Transactiondto();

        fakedto.setId(1);
        fakedto.setEmail("abc.j8@gmail.com");
        fakedto.setLastname("mat");
        fakedto.setFirstname("lixy");
        fakedto.setShared(true);
        fakedto.setAmount(2000);
        fakedto.setCategoryType("expenses");
        fakedto.setCategoryname("food");
        fakedto.setUserid(1);
        fakedto.setCategoryid(6);
        fakedto.setDescription("expense added");
        fakedto.setDate("12/12/2022");

        // Fake Transaction List for fakeuser
        fakeTransactions.add(new Transaction (1, 2000, df.parse("12/12/2022"),
                "expense added", true, fakecat, fakeuser));
        fakeTransactions.add(new Transaction(2, 300, df.parse("12/01/2022"),
                "grocery shopping", false, fakecat, fakeuser));

        // Fake Transaction DTO List for fakeuser
        fakeTransDto.add(new Transactiondto(1, 2000, "12/12/2022", 6,
                "expense added", "food", "expenses", 1, "lixy",
                "mat", "abc.j8@gmail.com", true));
        fakeTransDto.add(new Transactiondto(2, 300, "12/01/2022", 6,
                "grocery shopping", "food", "expenses", 1, "lixy",
                "mat", "abc.j8@gmail.com", false));


    }

    @Test
    public void addTransactionTest() throws BadParameterException {
        Mockito.lenient().when(transrepo.save(any())).thenReturn(faketransaction);

        Transactiondto actualdto = transserviceImp.addTransaction(faketransaction);
        Transactiondto expected = fakedto;
         Assertions.assertEquals(expected,actualdto);
}

    @Test
    public void findByUserTest() {

        when(transrepo.findByUser(eq(fakeuser))).thenReturn(fakeTransactions);

        List<Transactiondto> actual = transserviceImp.findByUser(fakeuser);
        List<Transactiondto> expected = new ArrayList<>(fakeTransDto);

        Assertions.assertEquals(expected, actual);

    }

   /* @Test
    void findByTransactiontype() throws BadParameterException {

        when(transrepo.findByTransactiontype(eq(fakeuser), eq(fakecat.getTranstype().getId()))).thenReturn(fakeTransactions);

        List<Transactiondto> actual = transserviceImp.findByTransactiontype(fakeuser, fakecat.getTranstype().getId());
        List<Transactiondto> expected = new ArrayList<>(fakeTransDto);

        Assertions.assertEquals(expected, actual);

    }*/

    @Test
    void findByTransactions() {
        when(transrepo.findByTransactions(eq(2022), eq(12), eq(fakeuser))).thenReturn(fakeTransactions);

        List<Transactiondto> actual = transserviceImp.findByTransactions(2022, 12, fakeuser);
        List<Transactiondto> expected = new ArrayList<>(fakeTransDto);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void updateTransaction() throws BadParameterException {
        int i=1;
        when(transrepo.findById(i)).thenReturn(Optional.ofNullable(faketransaction));
        Mockito.lenient().when(transrepo.save(faketransaction)).thenReturn(faketransaction);
        Transactiondto actualdto = transserviceImp.updateTransaction(faketransaction);
        Transactiondto expected = fakedto;
        Assertions.assertEquals(expected, actualdto);
    }

    @Test
    void deleteTransactionById() {
       // int i=1;
        //when(transrepo.getById(i)).thenReturn(faketransaction);
        //Mockito.lenient().when(transrepo.delete(faketransaction)).thenReturn()
    }

    @Test
    void findByCategoryBytranstype() {
    }
}