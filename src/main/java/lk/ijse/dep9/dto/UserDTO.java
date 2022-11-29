package lk.ijse.dep9.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    @NotBlank(message = "User name cannot be blank")
    @Pattern(regexp = "[A-Za-z0-9@_ ]+",message = "Invalid user name. '. + * ? ^ $ ( ) [ ] { } |' cannot be used ")
    private String userName;
    @NotBlank(message = "Full name cannot be blank")
    @Pattern(regexp = "[A-Za-z ]+",message = "Invalid Full Name")
    private String fullName;
    @NotBlank(message = "Password Cannot be Blank")
    private String password;
}
