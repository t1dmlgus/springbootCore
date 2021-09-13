package com.s1dmlgus.springbootCore.order.domain;

import com.s1dmlgus.springbootCore.member.domain.Member;

public interface DiscountPolicy {

    // 할인하기
    int discount(Member member, int price);
}
