package tel.ran.group.cvbank.model.web.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter

public class JobSeekerRegistrationRequest {
  @NotBlank(message = "login cannot be blank")
  @Length(
          min = 3,
          max = 20,
          message = "Length login must be between 3 and 20")
  private String login;
  private String  firstName;
  private String  lastName;
  @NotBlank(message = "email name cannot be blank")
  private String  email;
  @NotBlank(message = "phone name cannot be blank")
  private String  phone;
  @NotBlank(message = "password name cannot be blank")
  @Length(
          min = 3,
          max = 20,
          message = "Length password must be between 3 and 20")
  private String  password;
}
