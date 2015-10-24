package nao.cycledev.learnerew.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Word {

    @Id
    private String id;

    private String word;

    private String translation;

    private String details;

    public Word(String word, String translation, String details) {
        this.word = word;
        this.translation = translation;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Word: " + getId() + " " + getWord() + " = " + getTranslation();
    }

}
