package com.example.schedule.DTO.audience.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AudienceDTO {

    private Long id;

    private String name;

    @Override
    public String toString() {
        return "AudienceDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
