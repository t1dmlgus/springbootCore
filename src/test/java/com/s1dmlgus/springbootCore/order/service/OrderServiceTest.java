package com.s1dmlgus.springbootCore.order.service;

import com.s1dmlgus.springbootCore.AppConfig;
import com.s1dmlgus.springbootCore.member.domain.Grade;
import com.s1dmlgus.springbootCore.member.domain.Member;
import com.s1dmlgus.springbootCore.member.service.MemberService;
import com.s1dmlgus.springbootCore.member.service.MemberServiceImpl;
import com.s1dmlgus.springbootCore.order.domain.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void setUp(){
        AppConfig appConfig = new AppConfig();
        orderService = appConfig.orderService();
        memberService = appConfig.memberService();
    }


    @DisplayName("주문하기 테스트")
    @Test
    public void createOrder() throws Exception {
        //given
        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        //when
        Order orderA = orderService.createOrder(memberId, "itemName", 20000);

        System.out.println("orderA = " + orderA);

        //then
        //assertThat(orderA.getDiscountPrice()).isEqualTo(1000);
        assertThat(orderA.calculatePrice()).isEqualTo(19000);


    }
}