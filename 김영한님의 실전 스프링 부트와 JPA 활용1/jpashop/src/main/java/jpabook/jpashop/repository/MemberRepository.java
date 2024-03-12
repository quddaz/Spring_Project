package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.Member.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class MemberRepository {
  @PersistenceContext
  public EntityManager em;

  public Long save(Member member){
    em.persist(member);
    log.info("memberId= {}", member.getId());
    return member.getId();
  }
  public Member find(Long id){
    return em.find(Member.class, id);
  }
  public Member findOne(Long id) {
    return em.find(Member.class, id);
  }
  public List<Member> findAll(){
    return em.createQuery("select m from Member m", Member.class).getResultList();
  }
  public List<Member> findByName(String name){
    return em.createQuery("select m from Member m where m.name = :name", Member.class)
        .setParameter("name",name).getResultList();
  }

}

