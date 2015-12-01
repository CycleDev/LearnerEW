package nao.cycledev.learnerew.app.controller;

import nao.cycledev.learnerew.app.client.GroupClient;
import nao.cycledev.learnerew.view.GroupView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping({"/", "/home"})
public class HomeController {

    @Autowired
    private GroupClient groupClient;

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model) throws IOException {

        List<GroupView> groupViewList = groupClient.findAll();
        model.addAttribute("groups", groupViewList);
        return "home";
    }

}
