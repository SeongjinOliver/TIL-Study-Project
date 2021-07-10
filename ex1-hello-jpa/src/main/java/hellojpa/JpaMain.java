package hellojpa;

import java.util.List;
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
      // 비영속
      Member member = new Member();
      member.setId(100L);
      member.setName("HelloJPA");

      System.out.println("=== BEFORE ===");
      /*
       * 사실 이 때 DB에 저장되지 않는다.
       * 영속
       */
      em.persist(member);
      System.out.println("=== AFTER ===");

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
