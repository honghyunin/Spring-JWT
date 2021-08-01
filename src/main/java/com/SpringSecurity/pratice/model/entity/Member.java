package com.SpringSecurity.pratice.model.entity;

import lombok.Builder;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@NoArgsConstructor
@Entity
public class Member {
    @Id @Generated
    Long idx;

    @Column
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
