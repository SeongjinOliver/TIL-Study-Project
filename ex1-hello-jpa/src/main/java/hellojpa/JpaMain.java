package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
 *
 * Database와 연결도 되고 여러가지 기능을 사용할 수 있게된다.
 * createEntityManagerFactory는 Application 로딩 시점에 딱 하나만 만들어 두어야 한다.
 *
 * EntityManager entityManager = emf.createEntityManager();
 *
 * 실제 DB에 저장하거나 Transaction 단위로 사용되는 부분은(고객이 물건을 장바구니 등 쇼핑 Flow) emf.createEntityManager(); 이것을 꼭 만들어 주어야한다.
 */
public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Member member = new Member();
      member.setUsername("A");

      Member member2 = new Member();
      member2.setUsername("B");

      Member member3 = new Member();
      member3.setUsername("C");

      System.out.println("==============================");
      em.persist(member);
      em.persist(member2);
      em.persist(member3);

      System.out.println("member1 = " + member.getId()); //1, 51
      System.out.println("member2 = " + member2.getId());//Memory에서 호출
      System.out.println("member3 = " + member3.getId());//Memory 호출

      System.out.println("==============================");

      // 트랜잭션 커밋을 할 때 영속성 컨텍스트에 있는 객체가 DB에 쿼리가 날라가게 된다.
      tx.commit();
    } catch (Exception e) {
     tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
