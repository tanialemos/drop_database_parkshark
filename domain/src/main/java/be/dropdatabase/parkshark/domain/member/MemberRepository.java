package be.dropdatabase.parkshark.domain.member;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Member save (Member member){
        entityManager.persist(member);
        return member;
    }

    public Member findById(long memberId){
        return entityManager.find(Member.class, memberId);
    }

}
