package boot.jpa.junit.dto;

import boot.jpa.junit.domain.user.User;
import lombok.*;

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

    @Builder
    public UserUpdateRequestDto(Long id, String userName, String userId, String password) {
        this.id = id;
        this.userName = userName;
        this.userId = userId;
        this.password = password;
    }
}
