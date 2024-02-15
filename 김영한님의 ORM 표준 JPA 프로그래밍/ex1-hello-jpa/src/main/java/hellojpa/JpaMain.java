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

        //수정
        try {
            Member member = new Member();
            member.setName("회원1");
            //1차 캐시에 저장됨
            em.persist(member);
            //1차 캐시에서 조회
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
