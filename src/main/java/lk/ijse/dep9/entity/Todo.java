package lk.ijse.dep9.entity;

import jakarta.validation.constraints.NotEmpty;
import lk.ijse.dep9.entity.util.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Stack;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Todo implements SuperEntity{
    private int id;
    private String username;
    private String description;
    private Status status;
}
