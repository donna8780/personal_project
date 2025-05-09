package com.mediation.homepage.domain.request.service.create;

import com.mediation.homepage.domain.request.dto.req.RequestReqDto;
import com.mediation.homepage.domain.request.entity.Request;
import com.mediation.homepage.domain.request.mapper.RequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateRequestService {

    private final RequestMapper requestMapper;

    //의뢰 생성 메서드
    @Transactional
    public void createRequest(RequestReqDto requestReqDto){
        Request request = requestReqDto.toEntity();
        requestMapper.createRequest(request);
    }

}
