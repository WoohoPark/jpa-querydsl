package jpabook.start.chapter5;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "TEAM_MEMBER")
public class TeamMember {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    @Column(name = "USER_NAME")
    private String userName;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

}
