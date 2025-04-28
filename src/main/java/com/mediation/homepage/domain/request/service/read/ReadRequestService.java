package com.mediation.homepage.domain.request.service.read;

import com.mediation.homepage.domain.request.entity.Request;
import com.mediation.homepage.domain.request.mapper.RequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadRequestService {

    private final RequestMapper requestMapper;

    //의뢰 상세 조회 메서드
    public Request getRequestById(Long requestId){
        return requestMapper.findRequestById(requestId);
    }
}
