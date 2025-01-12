package kr.com.sparta.outsourcing.common.security.util;

import kr.com.sparta.outsourcing.common.security.dto.SecurityUserDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    private SecurityUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            return null; // 인증되지 않은 사용자
        }

        SecurityUserDto securityUserDto = (SecurityUserDto) authentication.getPrincipal();

        return securityUserDto.userId();
    }
}
