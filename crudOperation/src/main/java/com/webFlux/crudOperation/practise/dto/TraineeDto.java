package com.webFlux.crudOperation.practise.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TraineeDto {
    private String id;
    private String name;
    private String bloodGroup;
    private String domain;
}
