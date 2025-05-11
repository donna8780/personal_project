package com.mediation.homepage.domain.proposal.controller;

import com.mediation.homepage.domain.proposal.dto.req.CreateProposalReqDto;
import com.mediation.homepage.domain.proposal.service.DeleteProposalService;
import com.mediation.homepage.domain.proposal.service.create.CreateProposalService;
import com.mediation.homepage.domain.request.service.create.CreateRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proposals")
@RequiredArgsConstructor
public class ProposalController {
    private final DeleteProposalService deleteProposalService;
    private final CreateProposalService createProposalService;

    @PostMapping
    public ResponseEntity<String> createProposal(@RequestBody CreateProposalReqDto req) {
        createProposalService.createProposal(req);
        return ResponseEntity.ok().body("제안서 등록 완료");
    }
    @DeleteMapping
    public ResponseEntity<String> deleteProposal(@RequestParam Long proposalId) {
        deleteProposalService.deleteProposal(proposalId);
        return ResponseEntity.ok().body("제안서 삭제 완료");
    }
}
