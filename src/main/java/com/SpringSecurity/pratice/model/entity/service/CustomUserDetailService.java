package com.SpringSecurity.pratice.model.entity.service;

import com.SpringSecurity.pratice.model.entity.Member;
import com.SpringSecurity.pratice.model.entity.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username);
        if (username == null) { // 만약 그 받아온 username이 null일 경우에 exception
            throw new UsernameNotFoundException("해당 유저를 찾을 수 없습니다");
        }
        return member;
    }
}
