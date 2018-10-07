package tel.ran.group.cvbank.model.web.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequest {
    @NotBlank(message = "login cannot be blank")
    @Length(
            min = 3,
            max = 20,
            message = "Length login must be between 3 and 20")
    private String login;
    @NotBlank(message = "password name cannot be blank")
    @Length(
            min = 3,
            max = 20,
            message = "Length password must be between 3 and 20")
    private String password;
}
