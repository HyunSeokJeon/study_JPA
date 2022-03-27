package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            // 1차 캐시에 찾고 없네? - db에서 찾고 영속성 컨텍스트에 추가
            Member member = em.find(Member.class, 140L);
            member.setName("TEST");

            // 영속 -> 준영속 jpa 가 더이상 관리하지 않음
            em.detach(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
