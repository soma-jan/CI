package com.revature.Track2gether.service;


import com.revature.Track2gether.exception.BadParameterException;

import com.revature.Track2gether.dto.SignUpDTO;

import com.revature.Track2gether.model.Users;

import java.util.List;

public interface UserService {

    public Users addUser(Users user) throws BadParameterException;

    public Users getUserById(int id) throws BadParameterException;

}