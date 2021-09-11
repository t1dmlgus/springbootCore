package com.s1dmlgus.springbootCore.order.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;


@AllArgsConstructor
@Data
public class Order {

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;



}
