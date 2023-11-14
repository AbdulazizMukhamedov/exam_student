package uz.pdp.service;

import uz.pdp.entity.Group;
import uz.pdp.payload.GroupDTO;

import java.util.List;

public interface GroupService {
    List<GroupDTO> all();

    GroupDTO add(GroupDTO genreDTO);

    GroupDTO edit(Integer id, GroupDTO genreDTO);

    String delete(Integer id);

    Group getByIdOrElseThrow(Integer id);
}
