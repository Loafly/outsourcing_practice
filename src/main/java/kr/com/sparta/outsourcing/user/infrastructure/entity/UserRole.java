package kr.com.sparta.outsourcing.user.infrastructure.entity;

import kr.com.sparta.outsourcing.common.business.exception.ApiException;
import kr.com.sparta.outsourcing.common.business.exception.ErrorCode;

public enum UserRole {
    USER, OWNER
;

    public static UserRole fromString(String role) {
        try{
            return UserRole.valueOf(role);
        } catch (Exception e){
            throw new ApiException(ErrorCode.INVALID_USER_ROLE);
        }
    }
}
