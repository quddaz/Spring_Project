package Spring.data_jpa.domain.member.repository;

import Spring.data_jpa.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();
}
