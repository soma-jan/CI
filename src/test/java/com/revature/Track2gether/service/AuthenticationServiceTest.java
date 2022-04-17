package com.revature.Track2gether.service;


import com.revature.Track2gether.exception.BadParameterException;
import com.revature.Track2gether.model.Users;
import com.revature.Track2gether.repositories.UsersRepository;
import com.revature.Track2gether.service.AuthenticationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.security.auth.login.FailedLoginException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {

    @Mock
    private UsersRepository userRepo;

    @InjectMocks

    private AuthenticationService authService;

    Users fakeUser = new Users();
    Users fakeUser2 = new Users();

    @BeforeEach
    public void setup() throws ParseException {

        fakeUser.setId(99);
        fakeUser.setFirstname("firstName");
        fakeUser.setLastname("lastName");
        fakeUser.setPassword("password");
        fakeUser.setEmail("email@email.com");
        fakeUser.setSpouseId(fakeUser2);

        fakeUser2.setId(100);
        fakeUser2.setFirstname("fName");
        fakeUser2.setLastname("lName");
        fakeUser2.setPassword("pword");
        fakeUser2.setEmail("mail@email.com");
        fakeUser2.setSpouseId(fakeUser);

    }

    @Test
    @Timeout(value = 5000, unit = TimeUnit.MILLISECONDS)
    public void test_login_positive_validEmailAndPassword_noWhitespace() throws
            FailedLoginException, BadParameterException {

        when(userRepo.findByEmailAndPassword(eq("email@email.com"),
                eq("password"))).thenReturn(fakeUser);

        Users actual = authService.login("email@email.com", "password");

        Users expected = fakeUser;

        Assertions.assertEquals(expected, actual);

    }

   @Test
    @Timeout(value = 5000, unit = TimeUnit.MILLISECONDS)
    public void test_login_positive_validEmailAndPassword_whitespace() throws
            FailedLoginException, BadParameterException {

        when(userRepo.findByEmailAndPassword(eq("email@email.com"),
                eq("password"))).thenReturn(fakeUser);

        Users actual = authService.login("     email@email.com     ", "     password     ");

        Users expected = fakeUser;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    @Timeout(value = 5000, unit = TimeUnit.MILLISECONDS)
    public void test_login_invalidEmailAndPassword() throws FailedLoginException {

        Assertions.assertThrows(FailedLoginException.class, () -> {
            authService.login("invalid", "invalid");
        });
    }
}
