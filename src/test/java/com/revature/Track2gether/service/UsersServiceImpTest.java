package com.revature.Track2gether.service;

import com.revature.Track2gether.exception.BadParameterException;
import com.revature.Track2gether.model.Users;
import com.revature.Track2gether.repositories.UsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;

import java.text.ParseException;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsersServiceImpTest {

    @Mock
    private UsersRepository userRepo;

    @InjectMocks
    private UsersServiceImp usersServiceImp;

    Users fakeUser = new Users();
    Users fakeUser2 = new Users();



    @BeforeEach
    public void setup() throws ParseException {

        fakeUser.setId(88);
        fakeUser.setFirstname("testFirstName");
        fakeUser.setLastname("testLastName");
        fakeUser.setPassword("testPassword");
        fakeUser.setEmail("testemail@email.com");

        fakeUser2.setId(100);
        fakeUser2.setFirstname("fName");
        fakeUser2.setLastname("lName");
        fakeUser2.setPassword("pword");
        fakeUser2.setEmail("mail@email.com");
        fakeUser2.setSpouseId(fakeUser);

    }

    @Test
    public void test_getUserById() throws EntityNotFoundException, BadParameterException {
        // Arrange

        when(usersServiceImp.getUserById(eq(88))).thenReturn(fakeUser);

        // Act
        Users actual = usersServiceImp.getUserById(88);
        Users expected = fakeUser;

        //Assert

        Assertions.assertEquals(expected, actual);

    }
}
