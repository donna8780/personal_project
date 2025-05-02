package com.mediation.homepage.domain.request.service.read;

import com.mediation.homepage.domain.request.dto.resp.PageRespDto;
import com.mediation.homepage.domain.request.entity.Request;
import com.mediation.homepage.domain.request.mapper.RequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadRequestService {

    private final RequestMapper requestMapper;

    //의뢰 상세 조회 메서드
    public Request getRequestById(Long requestId){
        return requestMapper.findRequestById(requestId);
    }
    //의뢰 목록 조회 (페이징, 검색, 정렬 포함)
    public PageRespDto<Request> getAllRequests(int page, int size, String searchType, String keyword, String sortBy, String order) {
        //유효성 검증
        if (!isValidSortBy(sortBy)) {
            sortBy = "created_at"; //기본값
        }
        if(!isValidOrder(order)) {
            order = "desc"; // 기본값
        }
        int offset = (page - 1) * size;

        //요청 목록 가져오기
        List<Request> requestList = requestMapper.findAllRequests(offset, size, searchType, keyword, sortBy, order);

        //전체 데이터 개수 계산
        long totalCount = requestMapper.countRequestsWithFilter(searchType, keyword);

        //총 페이지 수 계산
        int totalPages = (int) Math.ceil((double) totalCount / size);

        //응답 dto생성 및 반환
        return new PageRespDto<>(requestList, page, size, totalCount, totalPages);
    }
    // 유효한 sortBy 값인지 확인
    private  boolean isValidSortBy(String sortBy) {
        return sortBy != null && (sortBy.equals("title") || sortBy.equals("created_at"));
    }

    private boolean isValidOrder(String order) {
        return order != null && (order.equals("asc") || order.equals("desc"));
    }

}
