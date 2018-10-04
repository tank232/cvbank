package tel.ran.group.cvbank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tel.ran.group.cvbank.model.entity.Company;

public interface CompanyRepository extends MongoRepository<Company, String> {
}
