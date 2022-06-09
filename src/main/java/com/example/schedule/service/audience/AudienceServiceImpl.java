package com.example.schedule.service.audience;

import com.example.schedule.DAO.audience.AudienceDAOImpl;
import com.example.schedule.DTO.audience.req.AudienceCreate;
import com.example.schedule.DTO.audience.req.AudienceUpdate;
import com.example.schedule.DTO.audience.resp.AudienceDTO;
import com.example.schedule.model.Audience;
import com.example.schedule.repository.AudienceRep;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AudienceServiceImpl  implements IAudienceService{

    private final AudienceDAOImpl dao;

    private final AudienceRep rep;


    @Override
    public Audience create(Audience audience) {
        return dao.create(audience);
    }

    @Override
    public Audience update(Audience audience) {
        return dao.update(audience);
    }

    @Override
    public String convertToDTOString(Long audienceId) {

        try {
            Audience audience = rep.getById(audienceId);
            return convertToDTO(audience).toString();
        }catch (Exception e){
            return "-DELETED AUDIENCE-";
        }

    }

    @Override
    public AudienceDTO createDTO(AudienceCreate entity) {

        Long id = (long) (rep.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        return convertToDTO(
                rep.save(Audience.builder()
                                .id(id)
                                .name(entity.getName())
                        .build())
        );
    }

    @Override
    public AudienceDTO updateDTO(AudienceUpdate entity) {

        Audience audience = rep.getById(entity.getId());

        return convertToDTO(
                rep.save(Audience.builder()
                        .id(audience.getId())
                        .name(entity.getName())
                        .build())
        );
    }

    @Override
    public AudienceDTO getById(Long id) {
        return convertToDTO(rep.getById(id));
    }

    @Override
    public Page<AudienceDTO> getAll(Integer page, Integer size) {

        Page<Audience> audiences = rep.findAll(PageRequest.of(page,size));

        var audiencesDTOs = audiences.get().map(this::convertToDTO).collect(Collectors.toList());

        return new PageImpl<AudienceDTO>(audiencesDTOs);
    }


    public AudienceDTO convertToDTO(Audience entity){
        return AudienceDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }



/*
    public Audience createDTO(AudienceDTOCreate request) {

        Long id = (long) (rep.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var audience = Audience.builder()
                .id(id)
                .name(request.getName())
                .build();

        return rep.save(audience);
    }

    public Audience updateDTO(AudienceDTOUpdate request) {

        var audience = Audience.builder()
                .id(rep.findById(request.getId()).get().getId())
                .name(request.getName())
                .build();

        return rep.save(audience);
    }*/
}
