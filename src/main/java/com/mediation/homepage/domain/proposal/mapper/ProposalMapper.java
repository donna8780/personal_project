package com.mediation.homepage.domain.proposal.mapper;

import com.mediation.homepage.domain.proposal.dto.req.CreateProposalReqDto;
import com.mediation.homepage.domain.proposal.entity.Proposal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProposalMapper {

    void createProposal(Proposal proposal);

    boolean existsProposal(@Param("proposalId") Long proposalId);

    void deleteProposal(@Param("proposalId") Long proposalId);

    Proposal findProposalById(@Param("proposalId") Long proposalId);
}
