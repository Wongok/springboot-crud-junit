package boot.jpa.junit.domain.user;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    UserRepository userRepository;

    @After
    public void cleanUp() {
        userRepository.deleteAll();
    }

    @Test
    public void UserSignUpRequest() {
        // given
        userRepository.save(User.builder()
        .userName("Park")
        .userId("Wongok")
        .password("1232")
        .build());

        // when
        User user = userRepository.findById(1l).orElse(null);

        //then
        Assert.assertThat(user.getUserId(), CoreMatchers.is("Wongok"));
    }
}
