package com.example.schedule.DTO.audience.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AudienceUpdate {

    private Long id;

    private String name;

}
