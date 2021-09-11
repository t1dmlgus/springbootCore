package com.s1dmlgus.springbootCore;

import com.s1dmlgus.springbootCore.member.domain.MemberRepository;
import com.s1dmlgus.springbootCore.member.domain.MemoryMemberRepository;
import com.s1dmlgus.springbootCore.member.service.MemberService;
import com.s1dmlgus.springbootCore.member.service.MemberServiceImpl;
import com.s1dmlgus.springbootCore.order.domain.DiscountPolicy;
import com.s1dmlgus.springbootCore.order.domain.FixDiscountPolicy;
import com.s1dmlgus.springbootCore.order.domain.RateDiscountPolicy;
import com.s1dmlgus.springbootCore.order.service.OrderService;
import com.s1dmlgus.springbootCore.order.service.OrderServiceImpl;
import org.springframework.context.annotation.Configuration;


public class AppConfig {

    // 리펙터링 -> 역할과 구현 분리

    // 생성자 주입
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }


    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }


}
