package jpabook.start.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<CategoryItem> categoryItems;

}
