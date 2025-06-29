package com.security.security_aula.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Define a classe como um controlador Rest
@RestController
@CrossOrigin("*")
public class WelcomeController {
    //Mapeia a rota padrão
    @GetMapping
    public String welcome() {
        return "Welcome";
    }

    //Mapeia a rota de usuários
    @GetMapping("/users")
    //Define as autorizações para todos os tipos
    @PreAuthorize("hasAnyRole('MANAGERS', 'USER')")
    public String users(){
        return "Authorized users";
    }

    //Mapeia a rota de administradores
    @GetMapping("/managers")
    //Define a permissão de acesso APENAS para usuários do tipo "MANAGERS"
    @PreAuthorize("hasRole('MANAGERS')")
    public String managers() {
        return "Hello, manager!";
    }
}
