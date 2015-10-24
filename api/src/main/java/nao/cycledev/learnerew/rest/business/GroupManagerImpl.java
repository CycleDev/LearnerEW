package nao.cycledev.learnerew.rest.business;

import nao.cycledev.learnerew.data.repository.GroupRepository;
import nao.cycledev.learnerew.view.GroupView;
import nao.cycledev.learnerew.view.factory.GroupViewFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupManagerImpl implements GroupManager {

    @Autowired
    private GroupRepository groupRepository;

    public List<GroupView> findAll() {

        return GroupViewFactory.fromList(groupRepository.findAll());

    }

}
