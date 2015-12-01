package nao.cycledev.learnerew.services;

import nao.cycledev.learnerew.business.GroupManager;
import nao.cycledev.learnerew.view.GroupView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupService {

    @Autowired
    private GroupManager groupManager;

    @RequestMapping(method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<GroupView> findAll() {
        return groupManager.findAll();
    }

}
