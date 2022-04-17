package com.revature.Track2gether.utility;

import com.revature.Track2gether.model.Category;
import com.revature.Track2gether.model.Transaction;
import com.revature.Track2gether.model.Transactiontype;
import com.revature.Track2gether.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DataPopulateUtility {
    @PersistenceContext
    private EntityManager em;

    /*
    @Autowired
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");


     */



    @Transactional
    public void populateIntialData() throws ParseException {
        Transactiontype income =new Transactiontype();
        income.setType("income");
        em.persist(income);

        Transactiontype expense =new Transactiontype();
        expense.setType("expenses");
        em.persist(expense);


    //Category


        Category salary =new Category();
        salary.setCategoryname("salary");
        salary.setTranstype(income);
        em.persist(salary);

        Category investment =new Category();
        investment.setCategoryname("investment");
        investment.setTranstype(income);
        em.persist(investment);

        Category other =new Category();
        other.setCategoryname("other");
        other.setTranstype(income);
        em.persist(other);

        Category otherexp =new Category();
        otherexp.setCategoryname("other");
        otherexp.setTranstype(expense);
        em.persist(other);

        Category housing =new Category();
        housing.setCategoryname("housing");
        housing.setTranstype(expense);;
        em.persist(housing);

        Category utilities =new Category();
        utilities.setCategoryname("utilities");
        utilities.setTranstype(expense);;
        em.persist(utilities);

        Category food =new Category();
        food.setCategoryname("food");
        food.setTranstype(expense);
        em.persist(food);

        Category transportation =new Category();
        transportation.setCategoryname("transportation");
        transportation.setTranstype(expense);
        em.persist(transportation);

        Category clothing =new Category();
        clothing.setCategoryname("clothing");
        clothing.setTranstype(expense);
        em.persist(clothing);

        Users user1 = new Users();
        user1.setFirstname("John");
        user1.setLastname("Doe");
        user1.setEmail("john@gmail.com");
        user1.setPassword("john123");
        em.persist(user1);

        Users user2 = new Users();
        user2.setFirstname("Emma");
        user2.setLastname("John");
        user2.setEmail("emma@gmail.com");
        user2.setPassword("emma123");
        em.persist(user2);

        user2.setSpouseId(user1);
        user1.setSpouseId(user2);

        // transaction

        String marDate1 = "03/09/2022";
        Date marDt1 = new SimpleDateFormat("MM/dd/yyyy").parse(marDate1);

        Transaction marchTrans1 = new Transaction();
        marchTrans1.setAmount(1840.73);
        marchTrans1.setDate(marDt1);
        marchTrans1.setDescription("Bi-weekly wage direct deposit");
        marchTrans1.setShared(false);
        marchTrans1.setCategory(salary);
        marchTrans1.setUser(user1);
        em.persist(marchTrans1);


        String marDate2 = "03/23/2022";
        Date marDt2 = new SimpleDateFormat("MM/dd/yyyy").parse(marDate2);

        Transaction marchTrans2 = new Transaction();
        marchTrans2.setAmount(1840.73);
        marchTrans2.setDate(marDt2);
        marchTrans2.setDescription("Bi-weekly wage direct deposit");
        marchTrans2.setShared(false);
        marchTrans2.setCategory(salary);
        marchTrans2.setUser(user1);
        em.persist(marchTrans2);

        String marDate3 = "03/12/2022";
        Date marDt3 = new SimpleDateFormat("MM/dd/yyyy").parse(marDate3);

        Transaction marchTrans3 = new Transaction();
        marchTrans3.setAmount(278.67);
        marchTrans3.setDate(marDt3);
        marchTrans3.setDescription("Expense for the spring clothing");
        marchTrans3.setShared(false);
        marchTrans3.setCategory(clothing);
        marchTrans3.setUser(user1);
        em.persist(marchTrans3);

        String marDate4 = "03/13/2022";
        Date marDt4 = new SimpleDateFormat("MM/dd/yyyy").parse(marDate4);

        Transaction marchTrans4 = new Transaction();
        marchTrans4.setAmount(213.87);
        marchTrans4.setDate(marDt4);
        marchTrans4.setDescription("Grocery shopping");
        marchTrans4.setShared(false);
        marchTrans4.setCategory(food);
        marchTrans4.setUser(user1);
        em.persist(marchTrans4);

        String marDate5 = "03/16/2022";
        Date marDt5 = new SimpleDateFormat("MM/dd/yyyy").parse(marDate5);

        Transaction marchTrans5 = new Transaction();
        marchTrans5.setAmount(66.89);
        marchTrans5.setDate(marDt5);
        marchTrans5.setDescription("Uber to DC");
        marchTrans5.setShared(false);
        marchTrans5.setCategory(transportation);
        marchTrans5.setUser(user1);
        em.persist(marchTrans5);

        String marDate6 = "03/31/2022";
        Date marDt6 = new SimpleDateFormat("MM/dd/yyyy").parse(marDate6);

        Transaction marchTrans6 = new Transaction();
        marchTrans6.setAmount(138.87);
        marchTrans6.setDate(marDt6);
        marchTrans6.setDescription("Electricity Bill");
        marchTrans6.setShared(false);
        marchTrans6.setCategory(utilities);
        marchTrans6.setUser(user1);
        em.persist(marchTrans6);



        String aprDate1 = "04/11/2022";
        Date aprDt1 = new SimpleDateFormat("MM/dd/yyyy").parse(aprDate1);

        Transaction aprTrans1 = new Transaction();
        aprTrans1.setAmount(389.99);
        aprTrans1.setDate(aprDt1);
        aprTrans1.setDescription("grocery shopping");
        aprTrans1.setShared(false);
        aprTrans1.setCategory(food);
        aprTrans1.setUser(user1);
        em.persist(aprTrans1);

        String aprDate2 = "04/2/2022";
        Date aprDt2 = new SimpleDateFormat("MM/dd/yyyy").parse(aprDate2);

        Transaction aprTrans2 = new Transaction();
        aprTrans2.setAmount(2160.58);
        aprTrans2.setDate(aprDt2);
        aprTrans2.setDescription("Rent for apartment");
        aprTrans2.setShared(true);
        aprTrans2.setCategory(housing);
        aprTrans2.setUser(user1);
        em.persist(aprTrans2);

        String aprDate3 = "04/06/2022";
        Date aprDt3 = new SimpleDateFormat("MM/dd/yyyy").parse(aprDate3);

        Transaction aprTrans3 = new Transaction();
        aprTrans3.setAmount(1840.73);
        aprTrans3.setDate(aprDt3);
        aprTrans3.setDescription("Bi-weekly wage direct deposit");
        aprTrans3.setShared(false);
        aprTrans3.setCategory(salary);
        aprTrans3.setUser(user1);
        em.persist(aprTrans3);

        String aprDate4 = "04/20/2022";
        Date aprDt4 = new SimpleDateFormat("MM/dd/yyyy").parse(aprDate4);

        Transaction aprTrans4 = new Transaction();
        aprTrans4.setAmount(1840.73);
        aprTrans4.setDate(aprDt4);
        aprTrans4.setDescription("Bi-weekly wage direct deposit");
        aprTrans4.setShared(false);
        aprTrans4.setCategory(salary);
        aprTrans4.setUser(user1);
        em.persist(aprTrans4);

        String aprDate5 = "04/08/2022";
        Date aprDt5 = new SimpleDateFormat("MM/dd/yyyy").parse(aprDate5);

        Transaction aprTrans5 = new Transaction();
        aprTrans5.setAmount(289.63);
        aprTrans5.setDate(aprDt5);
        aprTrans5.setDescription("Dinner at Sushi Ogawa");
        aprTrans5.setShared(false);
        aprTrans5.setCategory(food);
        aprTrans5.setUser(user1);
        em.persist(aprTrans5);

        String aprDate6 = "04/08/2022";
        Date aprDt6 = new SimpleDateFormat("MM/dd/yyyy").parse(aprDate6);

        Transaction aprTrans6 = new Transaction();
        aprTrans6.setAmount(5890.73);
        aprTrans6.setDate(aprDt6);
        aprTrans6.setDescription("Liquidated asset from my stock account");
        aprTrans6.setShared(false);
        aprTrans6.setCategory(investment);
        aprTrans6.setUser(user1);
        em.persist(aprTrans6);



        String aprDate7 = "05/12/2022";
        Date aprDt7 = new SimpleDateFormat("MM/dd/yyyy").parse(aprDate7);

        Transaction aprTrans7 = new Transaction();
        aprTrans7.setAmount(2000);
        aprTrans7.setDate(aprDt6);
        aprTrans7.setDescription("New kitchen appliance");
        aprTrans7.setShared(false);
        aprTrans7.setCategory(utilities);
        aprTrans7.setUser(user1);
        em.persist(aprTrans7);


        String aprDate8 = "01/01/2022";
        Date aprDt8 = new SimpleDateFormat("MM/dd/yyyy").parse(aprDate8);

        Transaction aprTrans8 = new Transaction();
        aprTrans8.setAmount(1000);
        aprTrans8.setDate(aprDt6);
        aprTrans8.setDescription("New cloth from zara");
        aprTrans8.setShared(false);
        aprTrans8.setCategory(clothing);
        aprTrans8.setUser(user2);
        em.persist(aprTrans8);

        String aprDate9 = "22/01/2022";
        Date aprDt9 = new SimpleDateFormat("MM/dd/yyyy").parse(aprDate9);

        Transaction aprTrans9 = new Transaction();
        aprTrans9.setAmount(80);
        aprTrans9.setDate(aprDt6);
        aprTrans9.setDescription("took uber to airport");
        aprTrans9.setShared(false);
        aprTrans9.setCategory(transportation);
        aprTrans9.setUser(user2);
        em.persist(aprTrans9);


        String aprDate10 = "10/02/2022";
        Date aprDt10 = new SimpleDateFormat("MM/dd/yyyy").parse(aprDate10);

        Transaction aprTrans10 = new Transaction();
        aprTrans10.setAmount(1000);
        aprTrans10.setDate(aprDt6);
        aprTrans10.setDescription("party at home");
        aprTrans10.setShared(false);
        aprTrans10.setCategory(other);
        aprTrans10.setUser(user2);
        em.persist(aprTrans10);

        String aprDate11 = "11/02/2022";
        Date aprDt11 = new SimpleDateFormat("MM/dd/yyyy").parse(aprDate11);

        Transaction aprTrans11 = new Transaction();
        aprTrans11.setAmount(200);
        aprTrans11.setDate(aprDt6);
        aprTrans11.setDescription("got  bonus");
        aprTrans11.setShared(false);
        aprTrans11.setCategory(salary);
        aprTrans11.setUser(user2);
        em.persist(aprTrans11);


        String aprDate12 = "11/02/2022";
        Date aprDt12 = new SimpleDateFormat("MM/dd/yyyy").parse(aprDate11);

        Transaction aprTrans12 = new Transaction();
        aprTrans12.setAmount(500);
        aprTrans12.setDate(aprDt6);
        aprTrans12.setDescription("birthday food ordered");
        aprTrans12.setShared(false);
        aprTrans12.setCategory(food);
        aprTrans12.setUser(user2);
        em.persist(aprTrans12);






    }
}

