package nao.cycledev.learnerew.app.controller;

import nao.cycledev.learnerew.view.info.GroupInfo;
import nao.cycledev.learnerew.view.GroupView;
import nao.cycledev.learnerew.app.client.GroupClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/groups")
public class GroupsController {

    @Autowired
    private GroupClient groupClient;

    @RequestMapping(method= RequestMethod.GET)
    public String getGroups(Model model) throws IOException {
        List<GroupView> groupViewList = groupClient.findAll();
        model.addAttribute("groups", groupViewList);
        return "groups";
    }

    @RequestMapping(value = "/delete", method= RequestMethod.GET)
    public String deleteGroup(@RequestParam(value = "groupId", required = true) String groupId)
            throws IOException {

        groupClient.delete(groupId);
        return "redirect:/groups/";
    }

    @RequestMapping(value = "/new", method= RequestMethod.GET)
    public String groupNew(Model model) throws IOException {
        model.addAttribute("group", new GroupView());
        model.addAttribute("title", "New group");
        return "group";
    }

    @RequestMapping(value = "/edit", method= RequestMethod.GET)
    public String groupEdit(@RequestParam(value = "groupId", required = true) String groupId, Model model)
            throws IOException {

        GroupView groupView = groupClient.find(groupId);
        model.addAttribute("group", groupView);
        model.addAttribute("title", "Edit group");
        return "group";
    }


    @RequestMapping(value = {"/new", "/edit"}, method= RequestMethod.POST)
    public String groupSave(@ModelAttribute("group") GroupInfo group) throws IOException {
        groupClient.save(group);
        return "redirect:/groups/";
    }

}
