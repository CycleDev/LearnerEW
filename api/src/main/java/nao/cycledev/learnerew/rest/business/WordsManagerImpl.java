package nao.cycledev.learnerew.rest.business;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WordsManagerImpl implements WordsManager {

    public List<String> findAll() {

        List<String> words = new ArrayList<>();
        words.add("word 1");
        words.add("word 2");
        words.add("word 3");
        words.add("word 4");

        return words;
    }

}
