package com.mediation.homepage.domain.proposal.mapper;

import com.mediation.homepage.domain.proposal.dto.req.CreateProposalReqDto;
import com.mediation.homepage.domain.proposal.entity.Proposal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProposalMapper {
    void createProposal(Proposal proposal);
}
