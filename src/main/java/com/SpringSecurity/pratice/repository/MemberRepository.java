package com.SpringSecurity.pratice.repository;

import com.SpringSecurity.pratice.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public String findByUsername(String username);
}
