package jpabook.start.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "CATEGORY_ITEM")
public class CategoryItem {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ITEM_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public void setCategory(Category category) {
        if(this.category != null){
            this.category.getCategoryItems().remove(this);
        }
        if(category != null){
            category.getCategoryItems().add(this);
        }
        this.category = category;
    }

    public void setItem(Item item) {
        if(this.item != null){
            this.item.getOrderItems().remove(this);
        }
        if(item != null){
            item.getCategoryItems().add(this);
        }
        this.item = item;
    }
}
