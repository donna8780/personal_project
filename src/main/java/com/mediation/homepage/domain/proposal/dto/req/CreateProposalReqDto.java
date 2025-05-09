package com.mediation.homepage.domain.proposal.dto.req;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProposalReqDto {
    @NotNull
    private Long requestId;

    @NotNull
    private String message;

    @Positive
    private Double proposalBudget;

}
