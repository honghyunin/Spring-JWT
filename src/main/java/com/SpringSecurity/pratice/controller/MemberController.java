package com.SpringSecurity.pratice.controller;

import com.SpringSecurity.pratice.model.entity.dto.MemberSignupRequestDto;
import com.SpringSecurity.pratice.service.Impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {
    private final MemberServiceImpl memberService;

    @PostMapping("signup")
    public String Signup(@RequestBody MemberSignupRequestDto requestDto) throws Exception {
        memberService.signup(requestDto);
        return "회원가입에 성공하였습니다.";
    }
}
