package jpabook.jpashop.dto.user.requestdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreateRequestDTO {

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters" )
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    private String bio;

    private String profileImageUrl;

}