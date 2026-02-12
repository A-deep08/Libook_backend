package net.engineeringdigest.journalApp.Repository;

import net.engineeringdigest.journalApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

