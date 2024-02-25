package hellojpa;

import hellojpa.domain.Member;
import hellojpa.domain.Team;
import hellojpa.domain.ValueType.Address;
import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(team);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(team);
            em.persist(member2);

            em.flush();
            em.clear();
            String jpql = "select m from Member m join fetch m.team";
            List<Member> members = em.createQuery(jpql, Member.class)
                .getResultList();
            for (Member member : members) {
                //페치 조인으로 회원과 팀을 함께 조회해서 지연 로딩X
                System.out.println("username = " + member.getUsername() + ", " +
                    "teamName = " + member.getTeam().getName());
            }
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
