package com.mediation.homepage.domain.request.dto;

import com.mediation.homepage.domain.request.entity.Request;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestReqDto {
    private String title; // 의뢰 제목
    private String description; // 의뢰 내용
    private Double budget; // 예상 예산
    private LocalDateTime deadline; // 의뢰 마감 기한

    //실제로 db에 저장할 엔티티 객체 생성 DTO -> 엔티티
    public Request toEntity() {
        Request request = new Request();//Long userId 넣기
        //request.setUserId(userId); //로그인 한 사용자 id를 받아서 사용
        request.setTitle(this.title);
        request.setDescription(this.description);
        request.setBudget(this.budget);
        request.setStatus("대기");
        request.setDeadline(this.deadline);
        request.setCreatedAt(LocalDateTime.now());
        request.setUpdatedAt(LocalDateTime.now());
        return request;
    }
}
