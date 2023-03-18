# jpa-querydsl


## JPA
객체 모델과 관계형 데이터 베이스 모델의 패러다임이 다르고 이를 극복하고자 개발자가 많은 시간과 코드를 소비한다.<br>
데이터베이스 중심 모델에서 객체 모델링으로 패러다임 불일치를 해결 해주고 정교한 객체 모델링을 유지하게 도와준다.

### 엔티티 생명주기
비영속성 : 엔티티 객체를 생성하였으나, 순수한 객체 상태이며 아직 저장하지 않은 상태<br>

영속성 : 엔티티 매니저를 통하여 객체를 저장하엿을 때 영속성 컨텍스트가 관리하는 상태<br>

준 영속성 : 영속성 컨텍스트에서 관리하던 엔티티가 매니저가 닫거나 정리되면서 분리된 상태를 의미한다.
비영속성 상태와 비슷하나 키를 갖고 있다.

삭제 : 엔티티를 영속성 컨텍스트와 데이터 베이스에서 삭제한 상태


### 영속성 컨텍스트란?
엔티티 매니저를 통해서 엔티티를 영구 저장하는 환경이다.

#### 영속성 컨텍스트의 특징
1. 식별자 값을 반드시 가지고 있어야 한다. 없는 경우 예외를 발생한다.
2. 영속성 컨텍스트와 데이터 베이스는 보통 트랜잭션 커밋하는 순간 엔티티의 값들을 반영한다 이를 플러시라고 한다.

#### 영속성 컨텍스트의 장점
1. 1차 캐시
2. 동일성 보장
3. 쓰기 지연
4. 변경 감지
5. 지연 로딩

#### 실전 예제 후기

내가 설계한 엔티티 모델은 결국 데이터 베이스 중심 설계이다.
객체 중심의 설계는 외래키가 아닌 참조를 사용해야된다.
(jpabook.start.domain.* 내용 참조)



### 단방향, 양방향


