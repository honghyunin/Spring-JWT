package com.SpringSecurity.pratice.model.entity.repository;

import com.SpringSecurity.pratice.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public Member findByUsername(String username);
    public Member findByEmail(String email);
}
