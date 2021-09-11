package com.s1dmlgus.springbootCore.order.domain;

import com.s1dmlgus.springbootCore.member.domain.Grade;
import com.s1dmlgus.springbootCore.member.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();


    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    @Test
    public void test_RateDiscount() throws Exception{
        //given
        Member member = new Member(1L, "mem", Grade.VIP);
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }


    //실패 테스트 중요!!
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    @Test
    public void test_RateDiscount2() throws Exception{
        //given
        Member member = new Member(1L, "mem", Grade.BASIC);
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }
    
}