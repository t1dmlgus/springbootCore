package com.s1dmlgus.springbootCore.member.service;


import com.s1dmlgus.springbootCore.member.domain.Member;
import org.springframework.stereotype.Service;


public interface MemberService {

    // 회원가입
    void join(Member member);

    // 회원조회
    Member findMember(Long memberId);
}
