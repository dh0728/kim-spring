package com.test_1.demo.springbootdeveloper;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id; //DB 테이블의 'id' 컬럼과 매칭

    @Column(name = "name", nullable = false)
    private String name; //DB 테이블의 'name' 컬럼과 매칭
}
