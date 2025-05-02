package com.mediation.homepage.domain.request.controller;

import com.mediation.homepage.domain.request.dto.req.RequestReqDto;
import com.mediation.homepage.domain.request.dto.resp.PageRespDto;
import com.mediation.homepage.domain.request.dto.resp.RequestRespDto;
import com.mediation.homepage.domain.request.entity.Request;
import com.mediation.homepage.domain.request.service.DeleteRequestService;
import com.mediation.homepage.domain.request.service.UpdateRequestService;
import com.mediation.homepage.domain.request.service.create.CreateRequestService;
import com.mediation.homepage.domain.request.service.read.ReadRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
@RequiredArgsConstructor
public class RequestController {

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
    public ResponseEntity<String> updateRequest(@PathVariable Long id, @RequestBody RequestRespDto respdto) {
        updateRequestService.updateRequest(id, respdto);
        return ResponseEntity.ok().body("수정 완료");
    }

    @GetMapping
    public ResponseEntity<PageRespDto<Request>> getListRequest(@RequestParam(defaultValue = "1") int page,
                                                               @RequestParam(defaultValue = "10") int size,
                                                               @RequestParam(required = false)String keyword,
                                                               @RequestParam(required = false, defaultValue = "title") String searchType,
                                                               @RequestParam(defaultValue = "created_at") String sortBy,
                                                               @RequestParam(defaultValue = "desc") String order) {
        PageRespDto<Request> response = readRequestService.getAllRequests(page, size, searchType,  keyword, sortBy, order);
        return ResponseEntity.ok().body(response);
    }
}
