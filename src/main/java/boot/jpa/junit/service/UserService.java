package boot.jpa.junit.service;

import boot.jpa.junit.domain.user.User;
import boot.jpa.junit.domain.user.UserRepository;
import boot.jpa.junit.dto.UserFindAllResponseDto;
import boot.jpa.junit.dto.UserFindByIdResponseDto;
import boot.jpa.junit.dto.UserSignUpRequestDto;
import boot.jpa.junit.dto.UserUpdateRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    @Transactional
    public Long userSignUpRequest(UserSignUpRequestDto dto) {
        return userRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public UserFindByIdResponseDto userFindByIdResponse(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return new UserFindByIdResponseDto(user);
    }

    @Transactional
    @ReadOnlyProperty
    public List<UserFindAllResponseDto> userFindAllResponse() {
        return userRepository.findAll().stream()
                .map(UserFindAllResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long userUpdateRequest(UserUpdateRequestDto dto){
        return userRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public void userDeleteRequest(Long id) {
        userRepository.deleteById(id);
    }
}
