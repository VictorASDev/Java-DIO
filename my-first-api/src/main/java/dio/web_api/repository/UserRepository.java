package dio.web_api.repository;

import dio.web_api.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public void save(User user) {
        if (user.getId() == null) {
            System.out.println("SAVE - salvando o usuário na camada repository");
        }
        else {
            System.out.println("UPDATE - salvando o usuário na camada repository");
        }
    }

    public void deleteByID(Integer id) {
        System.out.printf("DELETE - recebendo o id %d para na camada repository", id);
    }

    public void findByID(Integer id) {
        System.out.printf("FIND - recebendo o id %d para na camada repository", id);
    }

    public User findByLogin(String login) {
        System.out.printf("FIND BY LOGIN - recebendo o login %s para na camada repository", login);
        return new User(login, "123456");
    }

    public List<User> findAll() {
        System.out.println("FIND ALL - recebendo o id para na camada repository");
        List<User> usuarios = new ArrayList<>();
        usuarios.add(new User("Victor","123456"));
        usuarios.add(new User("Jorge", "123456"));
        return usuarios;
    }
}
