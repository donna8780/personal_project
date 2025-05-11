package com.mediation.homepage.domain.request.mapper;

import com.mediation.homepage.domain.request.dto.resp.RequestRespDto;
import com.mediation.homepage.domain.request.entity.Request;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RequestMapper {

    boolean existsByRequestId(@Param("requestId") Long requestId);
    //Request객체를 받아서 db에 새로 insert하는 메서드
    //xml 파일안에서 #{request.title}처럼 request 객체의 필드를 접근할 수 있게 이름을 지정
    void createRequest(Request request);

    //의뢰 상세 조회
    //xml 파일 안에서 #{id}로 사용할 수 있게, 이 파라미터의 이름을 'id'로 지정
    Request findRequestById(@Param("requestId") Long requestId);

    //의뢰 목록 조회 (페이징, 검색, 정렬 포함)
    List<Request> findAllRequests(@Param("offset") int offset,
                                  @Param("size") int size,
                                  @Param("searchType" )String searchType,
                                  @Param("keyword") String keyword,
                                  @Param("sortBy") String sortBy,
                                  @Param("order") String order);

    //필터링 조건으로 의뢰 개수 반환
    long countRequestsWithFilter(@Param("searchType") String searchType,
            @Param("keyword")String keyword);

    //의뢰 수정
    int updateRequestById(@Param("requestId") Long requestId, @Param("respdto") RequestRespDto respdto);

    //의뢰 삭제
    void deleteRequestById(@Param("requestId") Long requestId);
}
