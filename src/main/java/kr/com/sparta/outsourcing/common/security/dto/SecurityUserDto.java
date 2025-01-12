package kr.com.sparta.outsourcing.common.security.dto;

import kr.com.sparta.outsourcing.user.infrastructure.entity.UserRole;

public record SecurityUserDto(Long userId, UserRole userRole) { }
