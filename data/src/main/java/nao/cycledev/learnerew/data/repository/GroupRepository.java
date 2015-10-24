package nao.cycledev.learnerew.data.repository;

import nao.cycledev.learnerew.data.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, String> {
}
