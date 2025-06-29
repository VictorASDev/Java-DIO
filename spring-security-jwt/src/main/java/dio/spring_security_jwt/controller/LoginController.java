package dio.spring_security_jwt.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.spring_security_jwt.dtos.Login;
import dio.spring_security_jwt.dtos.Sessao;
import dio.spring_security_jwt.model.User;
import dio.spring_security_jwt.repository.UserRepository;
import dio.spring_security_jwt.security.JWTCreator;
import dio.spring_security_jwt.security.JWTObject;
import dio.spring_security_jwt.security.SecurityConfig;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Sessao logar(@RequestBody Login login) {
        User user = userRepository.findUserByUsername(login.getUsername());
        if (user != null) {
            boolean passworkOk = encoder.matches(login.getPassword(), user.getPassword());
            if(!passworkOk) {
                throw new RuntimeException("Senha inválida para o usuáriio " + login.getUsername());
            }
            Sessao sessao = new Sessao();
            sessao.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration(new Date(System.currentTimeMillis() + securityConfig.getExpiration()));
            jwtObject.setRoles(user.getRoles());
            sessao.setToken(JWTCreator.create(securityConfig.getPrefix(), securityConfig.getKey(), jwtObject));
            return sessao;
        }
        else {
            throw new RuntimeException("Erro ao tentar fazer login!");
        }
    }

    @GetMapping
    public String hello() {
        return "Olá Usuário!";
    }
}
