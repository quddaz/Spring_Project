package jpabook.jpashop.domain.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
@Slf4j
@Repository
public class MemberRepository{
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

}

