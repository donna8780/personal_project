package com.mediation.homepage.domain.proposal.service.create;

import com.mediation.homepage.domain.proposal.status.ProposalStatus;
import com.mediation.homepage.domain.proposal.dto.req.CreateProposalReqDto;
import com.mediation.homepage.domain.proposal.entity.Proposal;
import com.mediation.homepage.domain.proposal.mapper.ProposalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateProposalService {

    private final ProposalMapper proposalMapper;

    public void createProposal(CreateProposalReqDto req) {
        Proposal proposal = Proposal.builder()
                .proposalId(null) // DB에서 Auto Increment라면 null로 둠
                .requestId(req.getRequestId())
                .message(req.getMessage())
                .proposalBudget(req.getProposalBudget())
                .status(ProposalStatus.PENDING) // 기본값 설정
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        proposalMapper.createProposal(proposal);
    }
}
