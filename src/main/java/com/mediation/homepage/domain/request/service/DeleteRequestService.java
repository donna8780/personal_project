package com.mediation.homepage.domain.request.service;

import com.mediation.homepage.domain.request.mapper.RequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteRequestService {
    private final RequestMapper requestMapper;

    public void deleteRequest(Long requestId){
        requestMapper.deleteRequestById(requestId);
    }
}
