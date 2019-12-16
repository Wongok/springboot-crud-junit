package boot.jpa.junit.service;

import boot.jpa.junit.domain.user.UserRepository;
import boot.jpa.junit.dto.UserSignUpRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    @Transactional
    public Long userSignUpRequest(UserSignUpRequestDto dto) {
        return userRepository.save(dto.toEntity()).getId();
    }
}
