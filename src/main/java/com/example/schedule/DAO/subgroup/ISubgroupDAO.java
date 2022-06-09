package com.example.schedule.DAO.subgroup;

import com.example.schedule.model.Subgroup;
import org.springframework.stereotype.Service;

@Service
public interface ISubgroupDAO {

    Subgroup create (Subgroup subgroup);

    Subgroup update (Subgroup subgroup);

}
