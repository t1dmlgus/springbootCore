package com.s1dmlgus.springbootCore.member.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;


@AllArgsConstructor
@Data
public class Member {

    private Long Id;
    private String name;
    private Grade grade;


}
