package jpabook.start.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    //@ForeignKey(value = Member.class,foreignKeyDefinition = 1)
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
