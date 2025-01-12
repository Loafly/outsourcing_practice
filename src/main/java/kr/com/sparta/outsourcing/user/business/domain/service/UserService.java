package kr.com.sparta.outsourcing.user.business.domain.service;

import kr.com.sparta.outsourcing.common.business.exception.ApiException;
import kr.com.sparta.outsourcing.common.business.exception.ErrorCode;
import kr.com.sparta.outsourcing.common.security.jwt.JwtUtil;
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
    private final JwtUtil jwtUtil;

    // 회원가입
    public UserDomain createUser(String email, String password, String userRoleString) {
        // email이 이미 있는 경우 예외처리
        throwExceptionIfExistsByEmail(email);
        validatePassword(password);
        UserRole userRole = UserRole.fromString(userRoleString);

        return userRepository.save(email, PasswordEncoder.encode(password), userRole);
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


    // 로그인
    public String signIn(String email, String password) {
        UserDomain userDomain = userRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND_USER));

        boolean matches = PasswordEncoder.matches(password, userDomain.getPassword());

        // 패스워드가 틀린 경우
        if (!matches) {
            throw new ApiException(ErrorCode.MISMATCHES_PASSWORD);
        }
        return jwtUtil.generateToken(userDomain.getId());
    }


    private void validatePassword(String password) {
        // 대소문자(영문), 숫자, 특수문자 각각 최소 한 글자 이상 포함 & 8자 이상
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8,}$";

        if (!password.matches(passwordPattern)) {
            throw new ApiException(ErrorCode.INVALID_PASSWORD);
        }
    }

    // 유저 조회
    public UserDomain getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND_USER));
    }


    // 회원 탈퇴
    public void softDeleteUserByIdAndPassword(Long id, String password) {
        UserDomain userDomain = getById(id);

        boolean matches = PasswordEncoder.matches(password, userDomain.getPassword());

        if (!matches) {
            throw new ApiException(ErrorCode.MISMATCHES_PASSWORD);
        }
        userDomain.delete();

        userRepository.save(userDomain);
    }
}
