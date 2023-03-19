package jpabook.start.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "ITEM")
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems;

    private int price;

    @Column(name = "STOCK_QUANITY", nullable = false)
    private int stockQuanity;

}
