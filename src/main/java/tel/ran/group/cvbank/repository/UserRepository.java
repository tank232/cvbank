package tel.ran.group.cvbank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tel.ran.group.cvbank.model.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByLogin(String login);
    User findUserByLoginAndAndPassword(String login,String password);

}
