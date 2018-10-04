package tel.ran.group.cvbank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tel.ran.group.cvbank.model.entity.JobSeeker;

public interface JobSeekerRepository extends MongoRepository<JobSeeker, String>  {


    JobSeeker findAllByLogin(String login);
}
