package com.mediation.homepage.domain.proposal.service;

import com.mediation.homepage.domain.proposal.mapper.ProposalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProposalService {

    private final ProposalMapper proposalMapper;

    public void deleteProposal(Long proposalId) {

        boolean exist = proposalMapper.existsProposal(proposalId);
        if (!exist) {
            throw new IllegalStateException("해당 제안서 아이디가 존재하지 않습니다.");
        }
        proposalMapper.deleteProposal(proposalId);
    }
}
