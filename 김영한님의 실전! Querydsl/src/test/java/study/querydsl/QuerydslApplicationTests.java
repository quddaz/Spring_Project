package study.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.Hello;
import study.querydsl.entity.QHello;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QuerydslApplicationTests {

	@PersistenceContext
	EntityManager em;

	@Test
	@Transactional
	@Rollback(false)
	void contextLoads() {
		Hello hello = new Hello();
		em.persist(hello);

		JPAQueryFactory query = new JPAQueryFactory(em);
		QHello qHello = QHello.hello; // Querydsl Q타입 동작 확인

		Hello result = query
			.selectFrom(qHello)
			.fetchOne();


		assertThat(result).isEqualTo(hello);
		// Lombok 동작 확인 (hello.getId())
		assertThat(result.getId()).isEqualTo(hello.getId());
	}
}
