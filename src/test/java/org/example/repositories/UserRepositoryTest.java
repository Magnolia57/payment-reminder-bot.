package org.example.repositories;

import org.example.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByTelegramId_validId_returnsUser() {
        User user = new User();
        user.setTelegramId(123L);
        user.setUserName("Ваня");
        userRepository.save(user);
        Optional<User> userOptional = userRepository.findByTelegramId(123L);
        assertTrue(userOptional.isPresent());
        assertEquals(123L, userOptional.get().getTelegramId());
    }

    @Test
    void findByTelegramId_invalidId_returnEmptyOptional(){
        Optional<User> userOptional = userRepository.findByTelegramId(999999999L);
        assertTrue(userOptional.isEmpty());

    }
}