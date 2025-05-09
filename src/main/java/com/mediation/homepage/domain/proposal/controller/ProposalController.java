package com.mediation.homepage.domain.proposal.controller;

import com.mediation.homepage.domain.proposal.dto.req.CreateProposalReqDto;
import com.mediation.homepage.domain.proposal.service.create.CreateProposalService;
import com.mediation.homepage.domain.request.service.create.CreateRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposals")
@RequiredArgsConstructor
public class ProposalController {
    private final CreateRequestService createRequestService;
    private final CreateProposalService createProposalService;

    @PostMapping
    public ResponseEntity<String> createProposal(@RequestBody CreateProposalReqDto req) {
        createProposalService.createProposal(req);
        return ResponseEntity.ok().body("제안서 등록 완료");
    }
}
