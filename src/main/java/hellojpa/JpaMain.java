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
            Member member1 = new Member(40L, "member40");
            Member member2 = new Member(50L, "member50");
            Member member3 = new Member(60L, "member60");
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

            em.flush();
            System.out.println("============================");

            Member findMember1 = em.find(Member.class, 40L);
            Member findMember2 = em.find(Member.class, 50L);
            Member findMember3 = em.find(Member.class, 60L);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
