package com.revature.Track2gether.dto;

import com.revature.Track2gether.model.Users;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SignUpDTO {

    private String firstName1;
    private String lastName1;
    private String email1;
    private String password1;

    private String firstName2;
    private String lastName2;
    private String email2;
    private String password2;

    //private String spouseFirstName;
    //private String spouseLastName;
    //private String spouseEmail;
    //private String spousePassword;
}