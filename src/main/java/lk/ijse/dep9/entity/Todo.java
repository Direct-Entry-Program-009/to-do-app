package lk.ijse.dep9.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Todo implements SuperEntity{
    private int id;
    private String username;
    private String description;
    private String status;
}
