package com.example.schedule.DTO.group.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GroupCreate {

    private Long numberOfGroup;
    private Long subgroupsId;

}
