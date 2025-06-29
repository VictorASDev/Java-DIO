package com.security.security_aula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.security_aula.model.User;
import com.security.security_aula.repository.UserRepository;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/auth")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if(userRepository.findUserByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username já existe");
        }

        userRepository.save(user);
        return ResponseEntity.ok("Usuário criado com sucesso");
    }
}
