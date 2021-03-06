package nao.cycledev.learnerew.business;

import nao.cycledev.learnerew.view.WordView;
import nao.cycledev.learnerew.view.factory.WordViewFactory;
import nao.cycledev.learnerew.data.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WordManagerImpl implements WordManager {

    @Autowired
    private WordRepository wordRepository;

    public List<WordView> findAll() {

        return WordViewFactory.fromList(wordRepository.findAll());

    }

}
