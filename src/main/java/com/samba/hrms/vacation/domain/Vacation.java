package com.samba.hrms.vacation.domain;

import com.samba.hrms.member.domain.Member;
import com.samba.hrms.vacation.model.VacationType;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class Vacation {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private LocalDate vacationDate;

    @Enumerated(EnumType.STRING)
    private VacationType vacationType;

    @Column(columnDefinition = "boolean default false")
    private boolean isApproved;

    public Vacation() {
    }

    private Vacation(LocalDate vacationDate, VacationType vacationType, Member member) {
        this.member = member;
        this.vacationDate = vacationDate;
        this.vacationType = vacationType;
        this.isApproved = false;
    }

    public static Vacation createVacation(Member member, LocalDate vacationDate, VacationType vacationType) {
        return new Vacation(vacationDate, vacationType, member);
    }
}
