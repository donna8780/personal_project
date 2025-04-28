package com.mediation.homepage.domain.request.controller;

import com.mediation.homepage.domain.request.dto.RequestReqDto;
import com.mediation.homepage.domain.request.entity.Request;
import com.mediation.homepage.domain.request.service.create.CreateRequestService;
import com.mediation.homepage.domain.request.service.read.ReadRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
@RequiredArgsConstructor
public class requestController {

    private final CreateRequestService createRequestService;
    private final ReadRequestService readRequestService;

    @PostMapping
    public ResponseEntity<String> createRequest(@RequestBody RequestReqDto requestReqDto){
        createRequestService.createRequest(requestReqDto);
        return ResponseEntity.ok().body("의뢰 등록 완료");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequest(@PathVariable Long id) {
        Request request = readRequestService.getRequestById(id);
        return ResponseEntity.ok().body(request);
    }
}
