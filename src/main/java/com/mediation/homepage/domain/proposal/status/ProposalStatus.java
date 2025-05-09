package com.mediation.homepage.domain.proposal.status;

public enum ProposalStatus {
    PENDING,        // 제출 완료, 아직 수락/거절되지 않음
    ACCEPTED,       // 의뢰자가 제안을 수락함
    REJECTED,       // 의뢰자가 제안을 거절함
    CANCELED,       // 제안자가 직접 제안을 취소함
    EXPIRED         // 마감 기한이 지나 자동 만료됨
}
