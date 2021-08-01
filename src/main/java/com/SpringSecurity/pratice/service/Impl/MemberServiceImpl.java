package com.SpringSecurity.pratice.service.Impl;

import com.SpringSecurity.pratice.model.entity.Member;
import com.SpringSecurity.pratice.model.entity.dto.MemberSignupRequestDto;
import com.SpringSecurity.pratice.repository.MemberRepository;
import com.SpringSecurity.pratice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member signup(MemberSignupRequestDto requestDto) throws Exception {
        if(memberRepository.findByUsername(requestDto.getUsername()) != null){
            throw new Exception("이미 존재하는 유저입니다");
        }
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        return memberRepository.save(requestDto.toEntity());
    }
}
