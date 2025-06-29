package dio.spring_security_jwt.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "Welcome, " + authentication.getName() + "! Your roles: " + authentication.getAuthorities();
        }
        return "Welcome to my spring boot web API";
    }

    @GetMapping("/users")
    public String users() {
        return "User authorized";
    }

    @GetMapping("/managers")
    public String managers() {
        return "Manager authorized";
    }
}
