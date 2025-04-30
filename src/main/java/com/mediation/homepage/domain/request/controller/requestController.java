package com.mediation.homepage.domain.request.controller;

import com.mediation.homepage.domain.request.dto.req.RequestReqDto;
import com.mediation.homepage.domain.request.dto.resp.requestRespDto;
import com.mediation.homepage.domain.request.entity.Request;
import com.mediation.homepage.domain.request.service.DeleteRequestService;
import com.mediation.homepage.domain.request.service.UpdateRequestService;
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
    private final DeleteRequestService deleteRequestService;
    private final UpdateRequestService updateRequestService;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable Long id) {
        deleteRequestService.deleteRequest(id);
        return ResponseEntity.ok().body(id +"가 삭제되었습니다.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRequest(@PathVariable Long id, @RequestBody requestRespDto respdto) {
        updateRequestService.updateRequest(id, respdto);
        return ResponseEntity.ok().body("수정 완료");
    }
}
