package com.revature.Track2gether.repositories;

import com.revature.Track2gether.dto.SignUpDTO;
import com.revature.Track2gether.exception.BadParameterException;
import com.revature.Track2gether.model.Users;
import org.apache.catalina.users.SparseUserDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.auth.login.FailedLoginException;
import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    public abstract Users findByEmailAndPassword(String email, String password) throws FailedLoginException, BadParameterException;

}