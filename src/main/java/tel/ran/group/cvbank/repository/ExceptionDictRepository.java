package tel.ran.group.cvbank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tel.ran.group.cvbank.model.entity.ExceptionDict;

public interface ExceptionDictRepository extends MongoRepository<ExceptionDict, String> {
}
