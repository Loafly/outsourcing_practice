package kr.com.sparta.outsourcing.user.business.domain.entity;

import kr.com.sparta.outsourcing.common.business.exception.ApiException;
import kr.com.sparta.outsourcing.common.business.exception.ErrorCode;
import kr.com.sparta.outsourcing.common.util.PasswordEncoder;
import kr.com.sparta.outsourcing.user.infrastructure.entity.UserRole;
import lombok.Getter;

@Getter
public class UserDomain {
    private Long id;
    private final String email;
    private final String password;
    private final UserRole userRole;

    public UserDomain(String email, String password, String userRoleString) {
        validatePassword(password);
        UserRole userRole1 = UserRole.fromString(userRoleString);
        this.email = email;
        this.password = PasswordEncoder.encode(password);
        this.userRole = userRole1;
    }

    public UserDomain(Long id, String email, String password, UserRole userRole) {
        this.id = id;
        this.email = email;
        this.password = PasswordEncoder.encode(password);
        this.userRole = userRole;
    }

    private void validatePassword(String password) {
        // 대소문자(영문), 숫자, 특수문자 각각 최소 한 글자 이상 포함 & 8자 이상
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8,}$";

        if (!password.matches(passwordPattern)) {
            throw new ApiException(ErrorCode.INVALID_PASSWORD);
        }
    }

}
