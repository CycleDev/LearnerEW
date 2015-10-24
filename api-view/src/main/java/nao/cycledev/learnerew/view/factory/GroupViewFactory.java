package nao.cycledev.learnerew.view.factory;

import nao.cycledev.learnerew.data.model.Group;
import nao.cycledev.learnerew.view.GroupView;

import java.util.ArrayList;
import java.util.List;

public class GroupViewFactory {

    public static GroupView from(Group group){
        GroupView groupView = new GroupView();
        groupView.setId(group.getId());
        groupView.setName(group.getName());

        return groupView;
    }

    public static List<GroupView> fromList(List<Group> groups){
        List<GroupView> groupViews = new ArrayList<>();

        for (Group group : groups){
            groupViews.add(from(group));
        }
        return groupViews;
    }

}
