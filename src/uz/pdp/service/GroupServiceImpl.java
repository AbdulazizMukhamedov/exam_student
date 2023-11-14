package uz.pdp.service;

import uz.pdp.entity.Group;
import uz.pdp.entity.Student;
import uz.pdp.payload.GroupDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class GroupServiceImpl implements GroupService{

    private static GroupServiceImpl instance;

    public List<Group> groups = Collections.synchronizedList(new ArrayList<>());

    private static Lock lock = new ReentrantLock();

    private static Logger logger = Logger.getLogger("GroupService");

    private GroupServiceImpl() {
    }

    public static GroupServiceImpl getInstance() {

        if (Objects.isNull(instance)) {
            lock.lock();
            if (Objects.isNull(instance)) {
                instance = new GroupServiceImpl();
            }
            lock.unlock();
        }

        return instance;
    }
    @Override
    public List<GroupDTO> all() {
        return null;
    }

    @Override
    public GroupDTO add(GroupDTO genreDTO) {
        return null;
    }

    @Override
    public GroupDTO edit(Integer id, GroupDTO genreDTO) {
        return null;
    }

    @Override
    public String delete(Integer id) {
        return null;
    }

    @Override
    public Group getByIdOrElseThrow(Integer id) {
        return null;
    }
}
