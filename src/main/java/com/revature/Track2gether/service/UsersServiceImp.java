package com.revature.Track2gether.service;


import com.revature.Track2gether.dto.UserResponseDTO;
import com.revature.Track2gether.exception.BadParameterException;
import com.revature.Track2gether.dto.SignUpDTO;
import com.revature.Track2gether.dto.Transactiondto;
import com.revature.Track2gether.model.Transaction;
import org.mindrot.jbcrypt.BCrypt;


import com.revature.Track2gether.model.Users;
import com.revature.Track2gether.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsersServiceImp implements UserService {

    @Autowired
    private UsersRepository userrepo;


    @Override
    public Users addUser(Users user) throws BadParameterException {

        if (user.getFirstname().equals("") || user.getLastname().trim().equals("")
                || user.getEmail().trim().equals("") || user.getPassword().trim().equals("")) {
            throw new BadParameterException("Do not leave any information blank");
        }

        Users newUser = this.userrepo.save(user);
/*
        String algorithm = "SHA-256";
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);

 */
        return newUser;
    }

    @Override
    public Users getUserById(int id) throws EntityNotFoundException {
        try {
            Users user = userrepo.getById(id);
            return user;

        }catch (Exception e){
            throw new EntityNotFoundException("User not found....");
        }

    }
}