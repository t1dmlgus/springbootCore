package com.s1dmlgus.springbootCore.order.domain;

import com.s1dmlgus.springbootCore.member.domain.Grade;
import com.s1dmlgus.springbootCore.member.domain.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
