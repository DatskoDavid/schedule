package com.example.schedule.DTO.group.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GroupDTO {

    private Long id;
    private Long numberOfGroup;

    private String subgroupsId;

    @Override
    public String toString() {
        return "GroupDTO{" +
                "id=" + id +
                ", numberOfGroup=" + numberOfGroup +
                ", subgroupsId='" + subgroupsId + '\'' +
                '}';
    }
}
