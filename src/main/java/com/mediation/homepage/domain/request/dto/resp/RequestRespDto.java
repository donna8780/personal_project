package com.mediation.homepage.domain.request.dto.resp;

import com.mediation.homepage.domain.request.status.RequestStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestRespDto {
    private Long requestId;
    private String title;
    private String description;
    private Double budget;
    private LocalDateTime deadline;
    private RequestStatus status;
}
