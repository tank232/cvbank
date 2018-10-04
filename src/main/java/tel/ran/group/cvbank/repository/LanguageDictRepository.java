package tel.ran.group.cvbank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tel.ran.group.cvbank.model.entity.LanguageDict;

public interface LanguageDictRepository extends MongoRepository<LanguageDict, String> {
}
