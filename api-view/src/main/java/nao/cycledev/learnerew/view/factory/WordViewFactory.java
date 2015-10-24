package nao.cycledev.learnerew.view.factory;

import nao.cycledev.learnerew.data.model.Word;
import nao.cycledev.learnerew.view.WordView;

import java.util.ArrayList;
import java.util.List;

public class WordViewFactory {

    public static WordView from(Word word){
        WordView wordView = new WordView();
        wordView.setId(word.getId());
        wordView.setWord(word.getWord());
        wordView.setTranslation(word.getTranslation());
        wordView.setDetails(word.getDetails());

        return wordView;
    }

    public static List<WordView> fromList(List<Word> words){
        List<WordView> wordsView = new ArrayList<>();

        for (Word word : words){
            wordsView.add(from(word));
        }
        return wordsView;
    }

}
