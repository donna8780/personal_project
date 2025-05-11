package com.mediation.homepage.domain.proposal.service.read;

import com.mediation.homepage.domain.proposal.entity.Proposal;
import com.mediation.homepage.domain.proposal.mapper.ProposalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadProposerService {

    private final ProposalMapper proposalMapper;

    public Proposal getProposal(Long proposalId) {

        boolean exists = proposalMapper.existsProposal(proposalId);

        if(!exists) {
            throw new IllegalStateException("해당 제안서의 아이디가 존재하지 않습니다.");
        }
        return proposalMapper.findProposalById(proposalId);
    }
}
