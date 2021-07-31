package com.SpringSecurity.pratice.model.entity;

import lombok.Builder;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@RequiredArgsConstructor
@Entity
public class Member {
    @Generated
    Long idx;

    @Id @Column
    String email;

    @Column
    String username;

    @Column
    String password;

    @Builder
    public Member(Long idx, String email, String username, String password){
        this.idx = idx;
        this.email = email;
        this.username = username;
        this.password = password;
    }

}
