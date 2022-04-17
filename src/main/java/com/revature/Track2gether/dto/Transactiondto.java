package com.revature.Track2gether.dto;

import lombok.*;


import java.sql.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Transactiondto {


    private int id;
    double amount;
    private String date;
    private int categoryid;
    private String description;
    private String categoryname;
    private String categoryType;
    private int userid;
    private String firstname;
    private String lastname;
    private String email;
    private boolean shared;

   // private String spouseid;
  //  private String spousefirstname;
  //  private String spouselastname;
 //   private String spouseemail;
}
