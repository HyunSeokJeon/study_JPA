package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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
            member.setName("Hello123");

            // 영속 (1차 캐시에 저장됨)
            em.persist(member);

            // 1차 캐시에서 조회
            Member findMember = em.find(Member.class, "100L");

            // 데이터베이스에서 조회
            Member findMember2 = em.find(Member.class, "1L");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}