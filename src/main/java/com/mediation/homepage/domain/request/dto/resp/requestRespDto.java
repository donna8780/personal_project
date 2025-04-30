package com.mediation.homepage.domain.request.dto.resp;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class requestRespDto {
    private String title;
    private String description;
    private Double budget;
    private LocalDateTime deadline;
}
