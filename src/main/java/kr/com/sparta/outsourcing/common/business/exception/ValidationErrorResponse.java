package kr.com.sparta.outsourcing.common.business.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ValidationErrorResponse {
    private int status;
    private List<String> errors;
}
