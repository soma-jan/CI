package com.revature.Track2gether.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "amount")
    double amount;

    @Column(name= "date")
    private Date date;

    @Column(name= "description")
    private String description;

    @Column(name= "shared")
    private boolean shared;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Users user;

}