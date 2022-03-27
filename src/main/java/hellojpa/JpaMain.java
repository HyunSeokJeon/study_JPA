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
            Member member1 = new Member(110L, "member110");
            Member member2 = new Member(120L, "member120");
            Member member3 = new Member(1300L, "member130");
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

            em.setFlushMode(FlushModeType.COMMIT);
            List<Member> members1 = em.createQuery("select m from Member m", Member.class)
                    .getResultList();
            System.out.println("FlushModeType.COMMIT result size : " + members1.size());

            em.setFlushMode(FlushModeType.AUTO);
            List<Member> members2 = em.createQuery("select m from Member m", Member.class)
                    .getResultList();

            System.out.println("FlushModeType.AUTO result size : " + members2.size());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
