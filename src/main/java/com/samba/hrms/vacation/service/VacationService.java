package com.samba.hrms.vacation.service;

import com.samba.hrms.vacation.dto.VacationSaveRequestDto;
import com.samba.hrms.vacation.repository.VacationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VacationService {

    private final VacationRepository vacationRepository;

    public Long save(VacationSaveRequestDto requestDto) {

        vacationRepository.save(requestDto.toEntity());
    }

}
