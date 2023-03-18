package jpabook.start.domain;

import javax.persistence.*;

@Entity
public class OrderMember {

    @Id
    @GeneratedValue
    @Column(name = "memberId")
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipcode;

}
