package com.revature.Track2gether.dto;

import com.revature.Track2gether.model.Users;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserJwtDto {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private Users spouseId;

}