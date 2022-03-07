package com.samba.hrms.member.domain;

import com.samba.hrms.vacation.domain.Vacation;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String position;

    @OneToMany(mappedBy = "member")
    private List<Vacation> vacations = new ArrayList<>();
}
