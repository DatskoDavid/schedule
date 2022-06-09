package com.example.schedule.DAO.subgroup;

import com.example.schedule.model.Subgroup;
import com.example.schedule.repository.SubgroupRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubgroupDAOImpl implements ISubgroupDAO{

    @Autowired
    SubgroupRep repository;

    @Override
    public Subgroup create(Subgroup subgroup) {

        Long id = (long) (repository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        subgroup.setId(id);

        repository.save(subgroup);
        return subgroup;
    }

    @Override
    public Subgroup update(Subgroup subgroup) {
        subgroup.setId(subgroup.getId());

        repository.save(subgroup);

        return subgroup;
    }
}
