package com.samba.hrms.member.repository;

import com.samba.hrms.member.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findMember(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findMembers() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
