package com.example.schedule.DAO.group;

import com.example.schedule.model.Group;
import com.example.schedule.repository.GroupRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupDAOImpl implements IGroupDAO{

    @Autowired
    GroupRep repository;

    @Override
    public Group create(Group group) {

        Long id = (long) (repository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        group.setId(id);

        repository.save(group);

        return group;
    }

    @Override
    public Group update(Group group) {

        group.setId(group.getId());

        repository.save(group);

        return group;
    }
}
