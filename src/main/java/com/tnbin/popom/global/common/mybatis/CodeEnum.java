package com.tnbin.popom.global.common.mybatis;

/**
 * <p>마이바티스를 이용해 매핑 처리하고자 하는 열거행으로 정의된 문자열 타입의 코드 값을 가져오기 위한 인터페이스</p>
 *
 * @author 박 수 빈
 * @version 1.0
 */

public interface CodeEnum {
    /**
     * 열거형 내에 정의된 문자열 타입의 코드를 반환한다
     */
    String getCode();

    /**
     * 코드의 이름을 반환한다
     */
    String getLabel();
}
