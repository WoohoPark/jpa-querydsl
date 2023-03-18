package jpabook.start.chapter5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * @author holyeye
 */
public class Chapter5 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook"); //엔티티 매니저 팩토리 생성
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }
        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void logic(EntityManager em) {

        //단방향 팀회원-팀 (N:1) 관계

        Team team = new Team("team1","팀1");
        em.persist(team);
        Team findTeam = em.find(Team.class,"team1");
        System.out.println("find team info = id : "+ findTeam.getId() + " name : "+findTeam.getName());

        TeamMember teamMember = new TeamMember("member1","회원1",team);
        em.persist(teamMember);

        TeamMember teamMember2 = new TeamMember("member2","회원2",team);
        em.persist(teamMember2);

        String jpql = "select m from TeamMember m join m.team t where t.name=:teamName";

        List<TeamMember> members = em.createQuery(jpql,TeamMember.class)
                        .setParameter("teamName", "팀1")
                        .getResultList();

        members.stream()
                .forEach(member -> {
                    System.out.println("조회 : "+ member.getUserName());
                });

        Team team2 = new Team("team2","팀2");
        em.persist(team2);
        teamMember2.setTeam(team2);
    }
}
