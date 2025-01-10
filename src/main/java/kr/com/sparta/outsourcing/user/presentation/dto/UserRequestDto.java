package kr.com.sparta.outsourcing.user.presentation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequestDto {

    public record SignUpRequest(
            @NotBlank(message = "이메일은 필수입니다.") @Email(message = "이메일 형식이 아닙니다.") String email,
            @NotBlank(message = "비밀번호는 필수입니다.")  String password,
            @NotBlank(message = "사용자 권한은 필수입니다.") String userRole
    ) { }
}
