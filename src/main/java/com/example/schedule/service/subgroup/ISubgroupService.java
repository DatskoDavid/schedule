package com.example.schedule.service.subgroup;

import com.example.schedule.DTO.subGroup.req.SubGroupCreate;
import com.example.schedule.DTO.subGroup.req.SubGroupUpdate;
import com.example.schedule.DTO.subGroup.resp.SubGroupDTO;
import com.example.schedule.model.Subgroup;
import org.springframework.data.domain.Page;

public interface ISubgroupService {

    Subgroup create (Subgroup subgroup);

    Subgroup update (Subgroup subgroup);

    SubGroupDTO createDTO(SubGroupCreate entity);

    SubGroupDTO updateDTO(SubGroupUpdate entity);

    SubGroupDTO get(Long id);

    String convertToDTOString(Long subgroupsId);

    Page<SubGroupDTO> getAll(Integer page, Integer size);


}
