package com.SpringSecurity.pratice.model.entity.service;

import com.SpringSecurity.pratice.model.entity.Member;
import com.SpringSecurity.pratice.model.entity.dto.MemberSigninDto;
import com.SpringSecurity.pratice.model.entity.dto.MemberSignupRequestDto;

import java.util.Map;

public interface MemberService {
    Member signup (MemberSignupRequestDto requestDto) throws Exception;
    Member login (MemberSigninDto requestDto);
}
