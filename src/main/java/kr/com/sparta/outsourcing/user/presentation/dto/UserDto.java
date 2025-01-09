package kr.com.sparta.outsourcing.user.presentation.dto;

public class UserDto {


    public record SignUpRequest(String email, String password, String userRole) { }
}
