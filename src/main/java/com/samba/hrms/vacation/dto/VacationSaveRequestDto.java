package com.samba.hrms.vacation.dto;

import com.samba.hrms.member.domain.Member;
import com.samba.hrms.vacation.domain.Vacation;
import com.samba.hrms.vacation.model.VacationType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class VacationSaveRequestDto {

    private final Long memberId;
    private final LocalDate vacationDate;
    private final VacationType vacationType;

    public Vacation toEntity() {
        Member member = new Member();
        return Vacation.createVacation(member, vacationDate, vacationType);
    }
}
