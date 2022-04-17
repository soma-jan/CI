package com.revature.Track2gether.service;

import com.revature.Track2gether.exception.BadParameterException;
import com.revature.Track2gether.model.Users;
import com.revature.Track2gether.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.FailedLoginException;

@Service
public class AuthenticationService {

    @Autowired
    private UsersRepository userRepo;

    public Users login(String email, String password) throws FailedLoginException, BadParameterException {

        // If they didn't input a username or password at all
        if (email.trim().equals("") || password.trim().equals("")) {
            throw new BadParameterException("You must provide a email and password to log in");
        }

        // trim() will trim all leading and trailing whitespace
        Users users = userRepo.findByEmailAndPassword(email.trim(), password.trim());

        // No User in the database matched a particular username and password
        if (users == null) {
            throw new FailedLoginException("Invalid email and/or password");
        }

        return users;
    }

}