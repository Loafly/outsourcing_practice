package kr.com.sparta.outsourcing.user.business.application;

import kr.com.sparta.outsourcing.common.annotation.Facade;
import kr.com.sparta.outsourcing.user.business.domain.entity.UserDomain;
import kr.com.sparta.outsourcing.user.business.domain.service.UserService;
import kr.com.sparta.outsourcing.user.presentation.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Facade
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    // 회원가입
    @Transactional
    public UserDomain signUp(UserRequestDto.SignUpRequest signUpRequest) {

        return userService.createUser(
                signUpRequest.email(), signUpRequest.password(), signUpRequest.userRole()
        );
    }
}
