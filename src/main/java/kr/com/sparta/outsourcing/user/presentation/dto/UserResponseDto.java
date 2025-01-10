package kr.com.sparta.outsourcing.user.presentation.dto;

import kr.com.sparta.outsourcing.user.business.domain.entity.UserDomain;

public record UserResponseDto(String email, String userRole) {

    public UserResponseDto(UserDomain userDomain) {
        this(
                userDomain.getEmail(),
                userDomain.getUserRole().toString()
        );
    }
}
