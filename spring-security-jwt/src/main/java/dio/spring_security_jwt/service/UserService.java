package dio.spring_security_jwt.service;

import dio.spring_security_jwt.model.User;
import dio.spring_security_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(User user) {
        String pass = user.getPassword();
        //Criptografa a senha antes de salvar no banco
        user.setPassword(passwordEncoder.encode(pass));
        userRepository.save(user);
    }
}
