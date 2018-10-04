package tel.ran.group.cvbank.repository;

import org.springframework.stereotype.Repository;
import tel.ran.group.cvbank.model.entity.User;
import tel.ran.group.cvbank.model.entity.UserSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserSessionRepository {

    private static Map<String, UserSession> sessions = new HashMap<>();

    public void create(String sessionId, User user) {
        UserSession userSession = UserSession
                .builder()
                .sessionId(sessionId)
                .user(user)
                .isValid(true)
                .build();
        sessions.putIfAbsent(sessionId, userSession);

    }

    public UserSession getBySessionId(String sessionId) {
        UserSession userSession = sessions.get(sessionId);
        if (userSession == null || !userSession.getIsValid()) {
            return null;
        }


        return userSession;
    }

    public String getToken(String login) {
        String token = sessions.entrySet()
                .stream()
                .filter(value -> value.getValue().getUser().getLogin().equals(login))
                .map(Map.Entry::getKey)
                .findFirst().get();
        return token;

    }

    public void invalidateSession(String sessionId) {
        UserSession userSession = sessions.get(sessionId);
        if (userSession == null) {
            return;
        }
        userSession.setIsValid(false);
        sessions.put(sessionId, userSession);
    }
}
