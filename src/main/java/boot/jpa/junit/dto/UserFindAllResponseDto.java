package boot.jpa.junit.dto;

import boot.jpa.junit.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class UserFindAllResponseDto {
    private Long id;
    private String userName;
    private String userId;
    private String password;
    private String createdDate;
    private String modifiedDate;

    public UserFindAllResponseDto(User entity) {
        id = entity.getId();
        userName = entity.getUserName();
        userId = entity.getUserId();
        password = entity.getPassword();
        createdDate = toStringLocalDateTime(entity.getCreatedDate());
        modifiedDate = toStringLocalDateTime(entity.getModifiedDate());
    }

    public String toStringLocalDateTime(LocalDateTime modifiedDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(modifiedDate)
                .map(formatter::format)
    .orElse("");
    }
}
