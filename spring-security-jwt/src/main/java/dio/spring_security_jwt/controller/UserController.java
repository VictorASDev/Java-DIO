package dio.spring_security_jwt.controller;

import dio.spring_security_jwt.model.User;
import dio.spring_security_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/users")
    public void postUser(@RequestBody User user) {
        userService.createUser(user);
    }
}
