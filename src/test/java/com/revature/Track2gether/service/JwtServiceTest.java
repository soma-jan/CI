package com.revature.Track2gether.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.Track2gether.model.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JwtServiceTest {

    private JwtService jwtService;

    Users fakeUser = new Users();
    Users fakeUser2 = new Users();

    @BeforeEach
    public void setup() {
        jwtService = new JwtService();

        fakeUser.setId(77);
        fakeUser.setFirstname("pFirstName");
        fakeUser.setLastname("pLastName");
        fakeUser.setEmail("pmail@email.com");
        fakeUser.setPassword("pssword");
        fakeUser.setSpouseId(fakeUser2);

        fakeUser2.setId(78);
        fakeUser2.setFirstname("sFirstName");
        fakeUser2.setLastname("sLastName");
        fakeUser2.setEmail("smail@email.com");
        fakeUser2.setPassword("pasword");
        fakeUser2.setSpouseId(fakeUser);

    }

    @Test
    public void test_createJWT() throws JsonProcessingException {
        String jwt = jwtService.createJwt(fakeUser);
        Assertions.assertNotNull(jwt);
    }

}
