package dio.aula_springDataJpa;

import dio.aula_springDataJpa.model.User;
import dio.aula_springDataJpa.repository.UserRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Table(name = "tab_user")
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        try {
            User user = new User();
            user.setName("Victor");
            user.setUsername("victor");
            user.setPassword("senha123");

            userRepository.save(user);
        } catch (Exception e) {
            throw new Exception(e);
        }

        for (User u: userRepository.findAll()) {
            System.out.println(u);
        }
    }
}
