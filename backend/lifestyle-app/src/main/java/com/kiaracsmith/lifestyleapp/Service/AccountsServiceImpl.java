package com.kiaracsmith.lifestyleapp.Service;

import java.util.Optional;

import com.kiaracsmith.lifestyleapp.Entities.UserDetails;
import com.kiaracsmith.lifestyleapp.Repositories.AccountsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class AccountsServiceImpl implements AccountsService {
    
    @Autowired
    private AccountsRepository accountsRepository;

    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/


    @Override
    public UserDetails findUserByEmail(String email) {
        UserDetails user = accountsRepository.findByEmail(email);

        if (user != null) {
            return user;
        } else {
            // TODO return exception
            return null;
        }
    }

    /*@Override
    public void deleteUserByEmail(String email) {
        UserDetails user = accountsRepository.findByEmail(email);

        if (user != null) {
            accountsRepository.deleteByEmail(email);
        } else {
            // TODO return exception
        }
    }*/


    @Override
    public void saveUser(UserDetails user) {
        accountsRepository.save(user);
    }
}
