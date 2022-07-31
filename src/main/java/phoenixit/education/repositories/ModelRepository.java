package phoenixit.education.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import phoenixit.education.models.Model;

/**
 * Repository for working with MongoDB collections.
 */
public interface ModelRepository extends MongoRepository<Model, String> {

}
