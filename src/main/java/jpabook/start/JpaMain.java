package jpabook.start;

import jpabook.start.domain.*;

import javax.persistence.*;
import java.util.Date;

public class JpaMain {

    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            before(em);  //비즈니스 로직
            logic(em);
            tx.commit();//트랜잭션 커밋
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void before(EntityManager em) {

        Member member = Member.builder()
                            .name("회원1")
                            .city("Seoul").street("JongRo").zipcode("123-1").build();
        em.persist(member);
        System.out.println("====================================== Member 등록");

        Order order = Order.builder()
                .orderDate(new Date())
                .status(OrderStatus.ORDER)
                .member(member)
                .build();
        em.persist(order);
        System.out.println("====================================== Order 등록");

        Item item = Item.builder()
                .name("상품")
                .price(1000)
                .stockQuanity(10)
                .orderItems(null)
                .build();
        em.persist(item);
        System.out.println("====================================== Item 등록");

        OrderItem orderItem = OrderItem.builder()
                .order(order)
                .item(item)
                .orderPrice(item.getPrice())
                .count(1)
                .build();
        em.persist(orderItem);
        System.out.println("====================================== OrderItem 등록");

    }
    public static void logic(EntityManager em) {

        long orderId = 2L;

        Order order = em.find(Order.class,orderId);
        Member meber = order.getMember();
        System.out.println("MEMBER GET NAME : " + meber.getName());

        OrderItem orderItem = order.getOrderItems().get(0);
        Item item = orderItem.getItem();
        System.out.println("ITEM GET PRICE : " + item.getPrice());

    }
}
