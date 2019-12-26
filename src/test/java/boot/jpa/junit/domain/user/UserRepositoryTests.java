package boot.jpa.junit.domain.user;

import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
    public void UserSignUpRequestTest() {
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

    @Test
    public void UserFindAllResponseTest() {
        // given
        User user = User.builder()
                .userName("Park")
                .userId("Wongok")
                .password("1232")
                .build();
        userRepository.save(user);

        // when
        List<User> userList = userRepository.findAll();

        // then
        Assertions.assertThat(userList).hasSize(1);
    }

    @Test
    public void UserFindByIdResponseTest() {
        // given
        User user = User.builder()
                .userName("Park")
                .userId("Wongok")
                .password("1232")
                .build();
        userRepository.save(user);

        // when
        User savedUser = userRepository.findById(1L).orElse(null);

        // then
        Assertions.assertThat(savedUser.getUserId()).isEqualTo("Wongok");
    }

    @Test
    public void UserUpdateRequestTest() {
        // given
        User user = User.builder()
                .userName("Park")
                .userId("Wongok")
                .password("1232")
                .build();
        userRepository.save(user);

        // when
        userRepository.save(User.builder()
                .id(1L)
                .userName("Kim")
                .userId("RedOne")
                .password("333")
                .build());

        // then
        User updatedUser = userRepository.findById(1L).orElse(null);
        Assertions.assertThat(updatedUser.getId()).isEqualTo(user.getId());
        Assertions.assertThat(updatedUser.getUserId()).isEqualTo("RedOne");
    }

    @Test
    public void UserDeleteRequestTest() {
        // given
        User user = User.builder()
                .userName("Park")
                .userId("Wongok")
                .password("1232")
                .build();
        userRepository.save(user);

        // when
        userRepository.deleteById(1L);

        // then
        Assert.assertNull(userRepository.findById(1L).orElse(null));
    }
}
