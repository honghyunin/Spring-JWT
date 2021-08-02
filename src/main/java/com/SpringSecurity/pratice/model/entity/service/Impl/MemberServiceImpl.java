package com.SpringSecurity.pratice.model.entity.service.Impl;

import com.SpringSecurity.pratice.exception.NotMatchPasswordException;
import com.SpringSecurity.pratice.exception.UserAlreadyExistsException;
import com.SpringSecurity.pratice.model.entity.Member;
import com.SpringSecurity.pratice.model.entity.dto.MemberSigninDto;
import com.SpringSecurity.pratice.model.entity.dto.MemberSignupRequestDto;
import com.SpringSecurity.pratice.model.entity.repository.MemberRepository;
import com.SpringSecurity.pratice.model.entity.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member signup(MemberSignupRequestDto requestDto) throws Exception {
        if(memberRepository.findByUsername(requestDto.getUsername()) != null){
            throw new UserAlreadyExistsException();
        }
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));

        return memberRepository.save(requestDto.toEntity());
    }

    @Override
    public Member login(MemberSigninDto requestDto) {
        Member findMember = memberRepository.findByEmail(requestDto.getEmail());
        if(findMember == null) throw new UserAlreadyExistsException("유저를 찾을 수 없습니다");
        boolean passwordChcek = passwordEncoder.matches(requestDto.getPassword(), findMember.getPassword()); // 언코딩 후 dto에 저장된 pw갑과 db에 저장된 pw를 비교 후 같으면 true 다르면 false 반환
        if(!passwordChcek) throw new NotMatchPasswordException("올바르지 않은 비밀번호입니다.");

        return findMember;
    }
}
