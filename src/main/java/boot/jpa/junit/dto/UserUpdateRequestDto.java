package boot.jpa.junit.dto;

import boot.jpa.junit.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserUpdateRequestDto {

    private Long id;
    private String userName;
    private String userId;
    private String password;

    public User toEntity() {
        return User.builder()
                .id(id)
                .userName(userName)
                .userId(userId)
                .password(password)
                .build();
    }
}
