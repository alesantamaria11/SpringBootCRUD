package com.mycompany.UserWebApp;
import com.mycompany.UserWebApp.user.User;
import com.mycompany.UserWebApp.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired private UserRepository repo;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("ale.san@gmail.com");
        user.setPassword("ale1234");
        user.setFirstName("Ale");
        user.setLastName("Santamaria");

        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);

    }

}
