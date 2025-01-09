package kr.com.sparta.outsourcing.user.business.application;

import kr.com.sparta.outsourcing.common.annotation.Facade;
import kr.com.sparta.outsourcing.user.business.domain.service.UserService;
import kr.com.sparta.outsourcing.user.presentation.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Facade
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    // 회원가입
    @Transactional
    public void signUp(UserDto.SignUpRequest signUpRequest) {

        String email = signUpRequest.email();
        String password = signUpRequest.password();
        String userRole = signUpRequest.userRole();

        // email이 이미 있는 경우 예외처리
        userService.throwExceptionIfExistsByEmail(email);

        // 생성
        userService.createUser(email, password, userRole);
    }

}
