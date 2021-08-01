package com.SpringSecurity.pratice.service;

import com.SpringSecurity.pratice.model.entity.Member;
import com.SpringSecurity.pratice.model.entity.dto.MemberSignupRequestDto;

public interface MemberService {
    Member signup (MemberSignupRequestDto requestDto) throws Exception;
}
