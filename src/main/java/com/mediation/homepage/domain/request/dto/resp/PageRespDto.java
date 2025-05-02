package com.mediation.homepage.domain.request.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PageRespDto<T> {
    private List<T> requestList; //실제 데이터 리스트
    private int page; //현재 페이지 번호
    private int size; //한 페이지에 몇 개를 보여줄지
    private long totalCount; //전체 데이터 개수
    private int totalPages; // 전체 페이지수
}

