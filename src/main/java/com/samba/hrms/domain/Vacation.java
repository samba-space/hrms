package com.samba.hrms.domain;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
public class Vacation {

    @Id @GeneratedValue
    private Long id;

    @Column
    private Timestamp requestDate;

    @Column
    private boolean isApproved;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
}
