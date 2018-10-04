package tel.ran.group.cvbank.model.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserSession {
    private String sessionId;
    private User user;
    private Boolean isValid;
    private String login;
}
