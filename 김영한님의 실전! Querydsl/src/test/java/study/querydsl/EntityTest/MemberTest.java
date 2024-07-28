package study.querydsl.EntityTest;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.Member;
import study.querydsl.entity.QMember;
import study.querydsl.entity.Team;

import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class MemberTest {
    @PersistenceContext
    EntityManager em;
    @Test
    public void testEntity() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);
        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
        //초기화
        em.flush();
        em.clear();
//확인
        List<Member> members = em.createQuery("select m from Member m",
                Member.class)
            .getResultList();
        for (Member member : members) {
            System.out.println("member=" + member);
            System.out.println("-> member.team=" + member.getTeam());
        }
    }
    @Test
    public void startJPQL() {
        //member1을 찾아라.
        String qlString =
            "select m from Member m " +
                "where m.username = :username";
        Member findMember = em.createQuery(qlString, Member.class)
            .setParameter("username", "member1")
            .getSingleResult();
        Assertions.assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    @Test
    public void startQuerydsl() {
        //member1을 찾아라.
        QMember m = new QMember("m");
        Member findMember = queryFactory
            .select(m)
            .from(m)
            .where(m.username.eq("member1"))//파라미터 바인딩 처리
            .fetchOne();
        Assertions.assertThat(findMember.getUsername()).isEqualTo("member1");
    }
}