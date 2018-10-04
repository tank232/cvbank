package tel.ran.group.cvbank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tel.ran.group.cvbank.model.entity.CV;
import tel.ran.group.cvbank.model.entity.JobSeeker;

import java.util.Set;

public interface CVRepository extends MongoRepository<CV, String> {

    Set<CV> findByJobSeeker(JobSeeker jobSeeker);
}
