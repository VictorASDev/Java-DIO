package dio.aula_springDataJpa.repository;

import dio.aula_springDataJpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
