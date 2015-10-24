package nao.cycledev.learnerew.data.repository;

import nao.cycledev.learnerew.data.model.Word;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WordRepository extends MongoRepository<Word, String> {
}
