package com.example.demo.controllers;


import com.example.demo.UsernameAndPasswordObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
// actually there is gonna be only one user
public class PasswordsAndUsersController {

    // no database will be wired in the project for simplicity purposes
    private List<UsernameAndPasswordObject> availableUsernamesAndPasswords = new ArrayList();;

    public PasswordsAndUsersController() {
        this.generateFakeAvailableUsernamesAndPasswords();
    }

    public List<UsernameAndPasswordObject> getAvailableUsernamesAndPasswords() {
        return availableUsernamesAndPasswords;
    }

    public void setAvailableUsernamesAndPasswords(List<UsernameAndPasswordObject> availableUsernamesAndPasswords) {
        this.availableUsernamesAndPasswords = availableUsernamesAndPasswords;
    }

    private void generateFakeAvailableUsernamesAndPasswords() {
        UsernameAndPasswordObject usernameAndPasswordObject1 = new UsernameAndPasswordObject("password", "username");
        UsernameAndPasswordObject usernameAndPasswordObject2 = new UsernameAndPasswordObject("Akhtem", "Ways");
        UsernameAndPasswordObject usernameAndPasswordObject3 = new UsernameAndPasswordObject("altenar", "altenar");
        this.getAvailableUsernamesAndPasswords().add(usernameAndPasswordObject1);
        this.getAvailableUsernamesAndPasswords().add(usernameAndPasswordObject2);
        this.getAvailableUsernamesAndPasswords().add(usernameAndPasswordObject3);
    }

    @PostMapping("/authorize")
    public ResponseEntity<HttpStatus> authorize(@RequestBody() UsernameAndPasswordObject requestBody) {
        boolean exists = this.getAvailableUsernamesAndPasswords()
                .stream()
                .anyMatch(usernameAndPassword -> usernameAndPassword.getPassword()
                        .equals(requestBody.getPassword())
                            && usernameAndPassword.getUsername().equals(requestBody.getUsername()));
        if (exists) {
            return ResponseEntity.ok().body(HttpStatus.OK);
        } return ResponseEntity.ok().body(HttpStatus.NOT_FOUND);
    }
}
