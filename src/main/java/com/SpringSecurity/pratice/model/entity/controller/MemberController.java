package com.SpringSecurity.pratice.model.entity.controller;

import com.SpringSecurity.pratice.model.entity.dto.MemberSigninDto;
import com.SpringSecurity.pratice.model.entity.dto.MemberSignupRequestDto;
import com.SpringSecurity.pratice.model.entity.service.Impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {
    private final MemberServiceImpl memberService;

    @PostMapping("/signup")
    public String Signup(@RequestBody MemberSignupRequestDto requestDto) throws Exception {
        memberService.signup(requestDto);
        return "회원가입에 성공하였습니다.";
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody MemberSigninDto requestDto){
        memberService.login(requestDto);
        return "로그인 인증에 성공했습니다";
    }
}
