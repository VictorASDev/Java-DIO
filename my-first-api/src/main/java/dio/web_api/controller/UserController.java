package dio.web_api.controller;

import dio.web_api.model.User;
import dio.web_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return userRepository.findByLogin(username);
    }

    @PostMapping("/user")
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
