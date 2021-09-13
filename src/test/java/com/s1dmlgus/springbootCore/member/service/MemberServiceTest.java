package com.s1dmlgus.springbootCore.member.service;

import com.s1dmlgus.springbootCore.AppConfig;
import com.s1dmlgus.springbootCore.member.domain.Grade;
import com.s1dmlgus.springbootCore.member.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void setUp(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @DisplayName("회원가입 테스트")
    @Test
    public void test_join() throws Exception{
        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(memberA);
        Member findMember = memberService.findMember(1L);

        //then
        assertThat(memberA).isEqualTo(findMember);

    }

}