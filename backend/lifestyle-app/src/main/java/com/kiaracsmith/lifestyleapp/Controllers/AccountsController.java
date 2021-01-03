package com.kiaracsmith.lifestyleapp.Controllers;

import java.util.Collections;
import java.util.Map;

import com.kiaracsmith.lifestyleapp.Entities.UserDetails;
import com.kiaracsmith.lifestyleapp.Service.AccountsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountsController {

    @Autowired
    private AccountsServiceImpl accountsService;

    @PostMapping("/users/register")
    @ResponseBody
    public Map<String, String> register(UserDetails user) {
        UserDetails userExists = accountsService.findUserByEmail(user.getEmail());

        if (userExists != null) {
            return Collections.singletonMap("response", "user already exists");
        } else {
            accountsService.saveUser(user);
            return Collections.singletonMap("response", "user " + user.getEmail() + " added");
        }
    }

    @GetMapping("/users/")
    @ResponseBody
    public ResponseEntity<UserDetails> getUserByEmail(@RequestParam("email") String email, @RequestParam("password") String password) {
        UserDetails user = accountsService.findUserByEmail(email);

        if (user != null) {
            return new ResponseEntity<UserDetails>(user, new HttpHeaders(), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserDetails>(user, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
