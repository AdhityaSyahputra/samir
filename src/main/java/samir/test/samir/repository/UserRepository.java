package samir.test.samir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samir.test.samir.feature.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
