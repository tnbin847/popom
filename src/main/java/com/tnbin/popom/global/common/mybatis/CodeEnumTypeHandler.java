package com.tnbin.popom.global.common.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * <p>{@link CodeEnum} 인터페이스를 구현하는 열거형 클래스 타입의 코드값을 데이터베이스 작업을 위해 매핑 처리를 수행하는 타입 핸들러</p>
 *
 * @author 박 수 빈
 * @version 1.0
 */

@MappedTypes(CodeEnum.class)
public class CodeEnumTypeHandler<E extends Enum<E> & CodeEnum> extends BaseTypeHandler<E> {
    private final Class<E> type;    // 핸들러가 처리할 열거형 클래스 타입
    private final E[] constants;    // 해당 열거형 클래스 내에 정의되어 있는 상수를 담고 있는 배열

    public CodeEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null.");
        }//end if
        this.type = type;
        this.constants = type.getEnumConstants();
        if (!type.isInterface() && this.constants == null) {
            throw new IllegalArgumentException(type + " does not represent an enum type.");
        }//end if
    }

    /**
     * 데이터베이스로부터 가져온 코드값을 토대로 알맞은 열거형 클래스 타입의 상수값을 찾아 반환한다.
     *
     * @param dbCode    데이터베이스로부터 가져온 코드값
     * @return          열거형 클래스 타입 상수
     */
    private E toCodeEnum(String dbCode) {
        return Arrays.stream(constants)
                .filter(e -> e.getCode().equals(dbCode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot convert " + dbCode + " to " + type.getSimpleName() + "."));
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.wasNull() ? null : toCodeEnum(rs.getString(columnName));
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.wasNull() ? null : toCodeEnum(rs.getString(columnIndex));
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.wasNull() ? null : toCodeEnum(cs.getString(columnIndex));
    }
}