package boot.jpa.junit.dto;

import boot.jpa.junit.domain.user.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSignUpRequestDto {
    private String userName;
    private String userId;
    private String password;

    public User toEntity() {
        return User.builder()
                .userName(userName)
                .userId(userId)
                .password(password)
                .build();
    }

    @Builder
    public UserSignUpRequestDto(String userName, String userId, String password) {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
    }
}
