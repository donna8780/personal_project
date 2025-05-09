package com.mediation.homepage.domain.request.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediation.homepage.domain.request.status.RequestStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Request {

    private Long requestId; //요청 id PK
    //private Long userId; //유저 id FK
    private String title; //제목
    private String description; //상세 설명
    private Double budget; //예산
    private RequestStatus status;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt; //의뢰 작성 일시
    private LocalDateTime updatedAt; //의뢰 수정 일시
    private LocalDateTime deadline; //의뢰 마감 기한
}
