package boot.jpa.junit.domain.user;

import boot.jpa.junit.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String userId;

    @Column
    private String password;

    @Builder
    public User(Long id, String userName, String userId, String password) {
        this.id = id;
        this.userName = userName;
        this.userId = userId;
        this.password = password;
    }
}
