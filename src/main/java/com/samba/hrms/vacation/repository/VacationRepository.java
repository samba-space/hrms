package com.samba.hrms.vacation.repository;

import com.samba.hrms.vacation.domain.Vacation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
public class VacationRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Vacation vacation) {
        em.persist(vacation);
        return vacation.getId();
    }

    public Long delete(Vacation vacation) {
        em.remove(vacation);
        return vacation.getId();
    }

    public Vacation update(Vacation vacation) {
        return em.merge(vacation);
    }

    public Vacation findOne(Long id) {
        return em.find(Vacation.class, id);
    }

    public List<Vacation> findAll() {
        return em.createQuery("select v from Vacation  v", Vacation.class)
                .getResultList();
    }

    public List<Vacation> findByMemberId(Long memberId) {
        return em.createQuery("select v from Vacation v where v.member.id = :memberId", Vacation.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    public List<Vacation> findByPeriod(LocalDate startDate, LocalDate endDate) {
        return em.createQuery("select v from Vacation v where v.vacationDate between :startDate and :endDate", Vacation.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }
}
