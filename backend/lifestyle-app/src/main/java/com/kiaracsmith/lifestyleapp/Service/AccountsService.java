package com.kiaracsmith.lifestyleapp.Service;

import com.kiaracsmith.lifestyleapp.Entities.UserDetails;

public interface AccountsService {
    
    public UserDetails findUserByEmail(String email);

    //public UserDetails changeEmail();

    //public UserDetails changeFirstName(String firstName);

    //public UserDetails changeLastName(String lastName);

    //public UserDetails changePassword(String password);

    //public void deleteUserByEmail(String email);

    public void saveUser(UserDetails user);

}

