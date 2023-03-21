package jpabook.start.domain;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    private Date createDate;
    private Date lastModifiedDate;
}
