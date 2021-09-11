package com.s1dmlgus.springbootCore.member.service;

import com.s1dmlgus.springbootCore.member.domain.Member;
import com.s1dmlgus.springbootCore.member.domain.MemberRepository;
import com.s1dmlgus.springbootCore.member.domain.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId)
    {
        return memberRepository.findById(memberId);
    }

}
