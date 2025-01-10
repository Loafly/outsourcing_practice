package kr.com.sparta.outsourcing.user.business.domain.service;

import kr.com.sparta.outsourcing.common.util.PasswordEncoder;
import kr.com.sparta.outsourcing.user.business.domain.entity.UserDomain;
import kr.com.sparta.outsourcing.user.business.domain.repository.UserRepository;
import kr.com.sparta.outsourcing.user.infrastructure.entity.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원가입
    public UserDomain createUser(String email, String password, String userRole) {
        // email이 이미 있는 경우 예외처리
        throwExceptionIfExistsByEmail(email);

        UserDomain userDomain = new UserDomain(
                email,
                password,
                userRole
        );

        return userRepository.save(userDomain);
    }

    private void throwExceptionIfExistsByEmail(String email) {
        // 이미 존재하는 경우
        if (existsByEmail(email)) {
            throw new IllegalArgumentException("User with email " + email + " already exists");
        }
    }

    private boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
