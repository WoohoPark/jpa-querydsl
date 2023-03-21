package jpabook.start.domain;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("A")
public class Album extends Item {

    private String artis;
    private String etc;

}