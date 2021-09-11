package com.s1dmlgus.springbootCore.order.service;

import com.s1dmlgus.springbootCore.member.domain.Member;
import com.s1dmlgus.springbootCore.member.domain.MemberRepository;
import com.s1dmlgus.springbootCore.member.domain.MemoryMemberRepository;
import com.s1dmlgus.springbootCore.order.domain.DiscountPolicy;
import com.s1dmlgus.springbootCore.order.domain.FixDiscountPolicy;
import com.s1dmlgus.springbootCore.order.domain.Order;


public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        // 주문한 유저 찾아오고
        Member member = memberRepository.findById(memberId);
        
        // 단일책임원칙 -> 할인금액은 너가 알아서 계산해줘
        // 유저가 주문한 아이템 할인금액
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
