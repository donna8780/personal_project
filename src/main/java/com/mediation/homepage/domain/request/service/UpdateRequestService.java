package com.mediation.homepage.domain.request.service;

import com.mediation.homepage.domain.request.dto.resp.RequestRespDto;
import com.mediation.homepage.domain.request.entity.Request;
import com.mediation.homepage.domain.request.mapper.RequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateRequestService {
    private final RequestMapper requestMapper;

    public Request updateRequest(Long requestId, RequestRespDto respdto){
        requestMapper.updateRequestById(requestId, respdto);
        return requestMapper.findRequestById(requestId);
    }
}
