package com.kiaracsmith.lifestyleapp.Repositories;

import java.util.List;
import java.util.Optional;

import com.kiaracsmith.lifestyleapp.Entities.UserDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("accountsRepository")
public interface AccountsRepository extends JpaRepository<UserDetails, Long>{
    
    UserDetails findByEmail(String email);

    //List<UserDetails> findByFirstName(String firstName);
    
    //List<UserDetails> findByLastName(String lastName);

}
