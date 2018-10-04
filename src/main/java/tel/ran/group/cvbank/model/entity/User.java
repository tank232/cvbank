package tel.ran.group.cvbank.model.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "user")
public class User{
    @Id
    private String login;
    private String password;
    @Indexed(unique = true)
    private String email;
    @Indexed(unique = true)
    private String phone;
    private List<String> roles;
}
