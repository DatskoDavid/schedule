package com.example.schedule.DAO.audience;

import com.example.schedule.model.Audience;
import com.example.schedule.repository.AudienceRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AudienceDAOImpl implements IAudienceDAO{

    @Autowired
    AudienceRep repository;

    @Override
    public Audience create(Audience audience) {

        Long id = (long) (repository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        audience.setId(id);

        repository.save(audience);

        return audience;
    }

    @Override
    public Audience update(Audience audience) {

        audience.setId(audience.getId());

        repository.save(audience);

        return audience;
    }
}
