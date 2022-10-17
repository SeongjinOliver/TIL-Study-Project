package com.example.jpashoporder.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // JPA에서 reflection이나 proxy 기술을 사용해야 하는데 기본 생성자가 없으면 사용을 못하기 때문에 public으로 사용하는 것 보다 좋다.
    // JPA 스펙상 사용하자! JPA 도큐먼트에 써있는 것이다.
    protected Address() {

    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
