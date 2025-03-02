package kr.com.sparta.outsourcing.common.business.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "E001", "비밀번호는 최소 8자 이상이며, 대문자 / 소문자 / 숫자 / 특수문자를 각각 1글자 이상 포함해야 합니다."),
    INVALID_USER_ROLE(HttpStatus.BAD_REQUEST, "E002", "잘못된 권한입니다."),
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "N002", "존재하지 않는 사용자 이메일 입니다."),
    MISMATCHES_PASSWORD(HttpStatus.BAD_REQUEST, "E003", "패스워드가 일치하지 않습니다."),
;
    private final HttpStatus status;   // HTTP Status
    private final String errorCode;    // 에러 식별 코드
    private final String message;      // 기본 메시지

    ErrorCode(HttpStatus status, String errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }
}
