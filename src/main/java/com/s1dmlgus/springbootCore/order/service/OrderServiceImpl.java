package com.s1dmlgus.springbootCore.order.service;

import com.s1dmlgus.springbootCore.member.domain.Member;
import com.s1dmlgus.springbootCore.member.domain.MemberRepository;
import com.s1dmlgus.springbootCore.member.domain.MemoryMemberRepository;
import com.s1dmlgus.springbootCore.order.domain.DiscountPolicy;
import com.s1dmlgus.springbootCore.order.domain.FixDiscountPolicy;
import com.s1dmlgus.springbootCore.order.domain.Order;
import com.s1dmlgus.springbootCore.order.domain.RateDiscountPolicy;


public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    
    // OCP 위반 -> 클라이언트 코드의 변경이 일어나서는 안된다
    // DIP 위반 -> 추상클래스에 의존해야 한다.
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

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
