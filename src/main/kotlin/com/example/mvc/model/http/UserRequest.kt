package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder(
    "address",
    "email",
    "name",
    "age"
)
data class UserRequest (
    var name:String?=null
    ,var age:Int?=null
    ,var email:String?=null
    ,var address:String?=null
)
/**
 1. data 키워드
    - 컴파일러가 자동으로 메서드 생성
        * equals() / hashCode()
        * toString()
        * copy()
        * componentN() (destructuring 지원)
 2.  주 생성자 + 프로퍼티 선언
    - var name: String? → field + getter/setter 자동 생성
    [!] Java 에서 - 별도의 필드 선언(private String name;)과 생성자, getName()/setName() 작성 불필요)

 3. null safety
    - String? 타입은 null 허용 (? 없으면 컴파일 타임에 null 불가)
    - null 가능 타입과 불가능 타입이 엄격히 구분되어 NPE 위험을 줄임
    [!] Java 에서 - 모든 참조형 변수는 기본적으로 null 허용
                 - 별도 어노테이션(@Nullable, @NotNull)을 문서화용으로 붙일 뿐 컴파일러 차원 검증은 없음

 4. 디폴트 파라미터 값
    - 생성자 파라미터에 기본값 지정 가능 (=null)
    - 호출 시 일부만 넘겨도 다른 파라미터는 자동으로 기본값 사용
 */