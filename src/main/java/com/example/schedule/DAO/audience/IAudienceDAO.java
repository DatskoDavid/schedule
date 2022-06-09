package com.example.schedule.DAO.audience;

import com.example.schedule.model.Audience;
import org.springframework.stereotype.Service;

@Service
public interface IAudienceDAO {
    Audience create (Audience audience);

    Audience update (Audience audience);
}
