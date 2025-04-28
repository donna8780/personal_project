package com.mediation.homepage.domain.request.mapper;

import com.mediation.homepage.domain.request.entity.Request;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RequestMapper {

    //Request객체를 받아서 db에 새로 insert하는 메서드
    //xml 파일안에서 #{request.title}처럼 request 객체의 필드를 접근할 수 있게 이름을 지정
    int createRequest(Request request);

    //의뢰 상세 조회
    //xml 파일 안에서 #{id}로 사용할 수 있게, 이 파라미터의 이름을 'id'로 지정
    Request findRequestById(@Param("requestId") Long requestId);

}
