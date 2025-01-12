package kr.com.sparta.outsourcing.common.business.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiErrorResponse {
    private final String resultCode;
    private final String message;

    public ApiErrorResponse(ErrorCode errorCode) {
        this.resultCode = errorCode.getErrorCode();
        this.message = errorCode.getMessage();
    }
}
