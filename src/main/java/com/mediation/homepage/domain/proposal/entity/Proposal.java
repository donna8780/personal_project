package com.mediation.homepage.domain.proposal.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediation.homepage.domain.proposal.status.ProposalStatus;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class Proposal {
    private final Long proposalId; //제안 ID
    private final Long requestId;  //제안에 대한 의뢰ID(FK)
    //private final Long userId; //제안한 유저에 대한 ID

    private final String message; //제안 메세지
    private final Double proposalBudget; //제안 금액
    private final ProposalStatus status; //제안 상태

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final LocalDateTime createdAt; //제안 생성 시간
    private final LocalDateTime updatedAt; //제안 생성 날짜

    @Builder
    public Proposal(Long proposalId, Long requestId, String message, Double proposalBudget, ProposalStatus status, LocalDateTime createdAt, LocalDateTime updatedAt ) {
        this.proposalId = proposalId;
        this.requestId = requestId;
        this.message = message;
        this.proposalBudget = proposalBudget;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //메세지 수정 메서드
    public Proposal updateMessage(String newMessage) {
        return Proposal.builder()
                .proposalId(this.proposalId)
                .requestId(this.requestId)
                .message(newMessage)
                .proposalBudget(this.proposalBudget)
                .status(this.status)
                .createdAt(this.createdAt)
                .updatedAt(LocalDateTime.now())
                .build();
    }
}



