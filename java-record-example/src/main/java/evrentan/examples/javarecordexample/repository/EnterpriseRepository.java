package evrentan.examples.javarecordexample.repository;

import evrentan.examples.javarecordexample.entity.EnterpriseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends MongoRepository<EnterpriseEntity, String> {
}
