package tel.ran.group.cvbank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tel.ran.group.cvbank.model.entity.SkillDict;

public interface SkillDictRepository extends MongoRepository<SkillDict, String> {
}
