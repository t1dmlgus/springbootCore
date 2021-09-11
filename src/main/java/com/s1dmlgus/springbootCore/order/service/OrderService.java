package com.s1dmlgus.springbootCore.order.service;

import javax.persistence.criteria.Order;

public interface OrderService {

    // 주문하기(행동)
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
