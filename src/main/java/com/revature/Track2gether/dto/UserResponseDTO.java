package com.revature.Track2gether.dto;

import com.revature.Track2gether.model.Users;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserResponseDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int spouseId;
    private String spouseFirstName;
    private String spouseLastName;
    private String spouseEmail;
}