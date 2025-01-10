package kr.com.sparta.outsourcing.user.presentation.controller;

import jakarta.validation.Valid;
import kr.com.sparta.outsourcing.user.business.application.UserFacade;
import kr.com.sparta.outsourcing.user.presentation.dto.UserRequestDto;
import kr.com.sparta.outsourcing.user.presentation.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    // 회원가입
    @PostMapping("/sign-up")
    public UserResponseDto signUp(@Valid @RequestBody UserRequestDto.SignUpRequest signUpRequest) {
        return new UserResponseDto(userFacade.signUp(signUpRequest));
    }
}
