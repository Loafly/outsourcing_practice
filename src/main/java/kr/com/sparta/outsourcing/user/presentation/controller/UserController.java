package kr.com.sparta.outsourcing.user.presentation.controller;

import jakarta.validation.Valid;
import kr.com.sparta.outsourcing.common.security.util.SecurityUtil;
import kr.com.sparta.outsourcing.user.business.application.UserFacade;
import kr.com.sparta.outsourcing.user.presentation.dto.UserRequestDto;
import kr.com.sparta.outsourcing.user.presentation.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    // 로그인
    @PostMapping("/sign-in")
    public UserResponseDto.SignInResponse login(@Valid @RequestBody UserRequestDto.SignInRequest signInRequest) {
        return new UserResponseDto.SignInResponse(
                userFacade.signIn(signInRequest.email(), signInRequest.password())
        );
    }

    // 회원 탈퇴
    @DeleteMapping
    public void deleteUser(@Valid @RequestBody UserRequestDto.DeleteRequest deleteRequest) {
        Long currentUserId = SecurityUtil.getCurrentUserId();

        userFacade.deleteUser(currentUserId, deleteRequest.password());
    }
}
