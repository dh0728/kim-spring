package com.test_1.demo.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    MemberRepository memberRepository; //빈 주입

    public List<Member> getAllMember() {
        return memberRepository.findAll(); //맴버 목록 얻기
    }
}
