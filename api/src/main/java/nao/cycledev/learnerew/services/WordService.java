package nao.cycledev.learnerew.services;

import nao.cycledev.learnerew.business.WordManager;
import nao.cycledev.learnerew.view.WordView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/words")
public class WordService {

    @Autowired
    private WordManager wordManager;

    @RequestMapping(method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<WordView> findAll() {
        return wordManager.findAll();
    }

}
