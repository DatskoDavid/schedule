package com.example.schedule.service.audience;

import com.example.schedule.DTO.audience.req.AudienceCreate;
import com.example.schedule.DTO.audience.req.AudienceUpdate;
import com.example.schedule.DTO.audience.resp.AudienceDTO;
import com.example.schedule.model.Audience;
import org.springframework.data.domain.Page;

public interface IAudienceService {

    Audience create (Audience audience);

    Audience update (Audience audience);

    String convertToDTOString(Long audienceId);

    AudienceDTO createDTO(AudienceCreate entity);
    AudienceDTO updateDTO(AudienceUpdate entity);

    AudienceDTO getById(Long id);

    Page<AudienceDTO> getAll(Integer page, Integer size);

}
