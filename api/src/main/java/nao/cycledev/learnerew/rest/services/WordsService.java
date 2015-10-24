package nao.cycledev.learnerew.rest.services;

import nao.cycledev.learnerew.rest.business.WordsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/words")
public class WordsService {

    @Autowired
    private WordsManager wordsManager;

    @RequestMapping(method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<String> findAll() {
        return wordsManager.findAll();
    }

}
