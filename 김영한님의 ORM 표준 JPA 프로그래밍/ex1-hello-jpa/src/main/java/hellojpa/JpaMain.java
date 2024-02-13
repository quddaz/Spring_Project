package hellojpa;

import hellojpa.domain.Member;
import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        /*
        //저장
        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("helloA");
            em.persist(member);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        //조회
        try {
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = "+ findMember.getId());
            System.out.println("findMember.name =" + findMember.getName());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        //삭제
        try {
            Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

         */
        //수정
        try {
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJpa");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
