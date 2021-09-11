package com.s1dmlgus.springbootCore.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository{

    // 회원가입
    void save(Member member);

    // 회원조회
    Member findById(Long memberId);
}
