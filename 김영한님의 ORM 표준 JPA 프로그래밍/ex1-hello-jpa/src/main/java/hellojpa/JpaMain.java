package hellojpa;

import hellojpa.domain.Child;
import hellojpa.domain.Member;
import hellojpa.domain.Parent;
import hellojpa.domain.ValueType.Address;
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
            Address address = new Address("city","street","10000");
            Member member = new Member();
            member.setName("member1");
            member.setHomeAddress(address);

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new Address("city","street","10000"));
            member.getAddressHistory().add(new Address("city2","street2","10000"));

            em.persist(member);



            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
