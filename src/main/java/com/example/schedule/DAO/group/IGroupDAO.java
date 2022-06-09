package com.example.schedule.DAO.group;

import com.example.schedule.model.Group;
import org.springframework.stereotype.Service;

@Service
public interface IGroupDAO {
    Group create (Group group);

    Group update (Group group);
}
