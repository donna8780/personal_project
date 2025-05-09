package com.mediation.homepage.global.typehandler;

import com.mediation.homepage.domain.request.status.RequestStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

public class RequestStatusTypeHandler extends BaseTypeHandler<RequestStatus> {

    // Enum → DB 저장용 문자열
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, RequestStatus status, JdbcType jdbcType) throws SQLException {
        ps.setString(i, status.name()); // 예: PENDING, IN_PROGRESS 등 문자열로 저장
    }

    // DB 문자열 → Enum (by 컬럼 이름)
    @Override
    public RequestStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String status = rs.getString(columnName);
        return status == null ? null : RequestStatus.valueOf(status);
    }

    // DB 문자열 → Enum (by 컬럼 인덱스)
    @Override
    public RequestStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String status = rs.getString(columnIndex);
        return status == null ? null : RequestStatus.valueOf(status);
    }

    // 프로시저 호출 결과 처리
    @Override
    public RequestStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String status = cs.getString(columnIndex);
        return status == null ? null : RequestStatus.valueOf(status);
    }
}
