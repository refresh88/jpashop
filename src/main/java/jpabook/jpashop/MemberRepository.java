package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    /**
     * id를 반환하는 이유.
     * 커맨더랑 쿼리를 분리해라 원칙.
     * 저장을 하고나면 가급적이면 side effect를 일으키는 커맨드성이기 떄문에 리턴값을 거의 안만듬.
     * 그러나 id 정도만 있으면 조회하는데 쓸수 있으니 id 리턴.
     */
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
