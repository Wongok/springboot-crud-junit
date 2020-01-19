package boot.jpa.junit.service;

import boot.jpa.junit.domain.user.User;
import boot.jpa.junit.domain.user.UserRepository;
import boot.jpa.junit.dto.UserFindAllResponseDto;
import boot.jpa.junit.dto.UserFindByIdResponseDto;
import boot.jpa.junit.dto.UserSignUpRequestDto;
import boot.jpa.junit.dto.UserUpdateRequestDto;
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
public class UserServiceTests {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @After
    public void clean_up() {
        userRepository.deleteAll();
    }

    @Test
    public void userSignUpRequestTest() {
        // given
        UserSignUpRequestDto input = UserSignUpRequestDto.builder()
                .userId("Wongok")
                .userName("Park")
                .password("1234")
                .build();

        // when
        Long output = userService.userSignUpRequest(input);

        // then
        Assert.assertThat(output, CoreMatchers.is(1L));
    }

    @Test
    public void userFindByIdResponse() {
        // given
        UserSignUpRequestDto input = UserSignUpRequestDto.builder()
                .userId("Wongok")
                .userName("Park")
                .password("1234")
                .build();

        userService.userSignUpRequest(input);

        // when
        UserFindByIdResponseDto output = userService.userFindByIdResponse(1L);

        // then
        Assert.assertEquals(input.getUserId(), output.getUserId());
        Assert.assertEquals(input.getUserName(), output.getUserName());
        Assert.assertEquals(input.getPassword(), output.getPassword());
    }

    @Test
    public void userFindAllResponse() {
        // given
        for(int i = 0; i < 100; i++) {
            UserSignUpRequestDto input = UserSignUpRequestDto.builder()
                    .userId("Wongok" + i)
                    .userName("Park" + i)
                    .password("1234" + i)
                    .build();

            userService.userSignUpRequest(input);
        }

        // when
        List<UserFindAllResponseDto> output = userService.userFindAllResponse();

        // then
        Assertions.assertThat(output).hasSize(100);
    }
}
