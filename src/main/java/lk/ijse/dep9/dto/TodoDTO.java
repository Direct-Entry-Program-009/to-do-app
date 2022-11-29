package lk.ijse.dep9.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lk.ijse.dep9.dto.util.Groups;
import lk.ijse.dep9.dto.util.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TodoDTO implements Serializable {

    @NotBlank (groups = {Groups.Delete.class, Groups.Update.class}, message = "Id cannot be empty")
    int id;

    @NotBlank (message = "Username cannot be empty")
    @Pattern(regexp = "[A-Za-z ]+")
    String username;

    @NotBlank (message = "Description cannot be empty")
    @Pattern(regexp = "[A-Za-z ,.]+")
    String description;

    @NotBlank (message = "Status cannot be empty")
    Status status;
}
