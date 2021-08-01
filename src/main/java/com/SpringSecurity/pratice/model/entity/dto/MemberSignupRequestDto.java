package com.SpringSecurity.pratice.model.entity.dto;

import com.SpringSecurity.pratice.model.entity.Member;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class MemberSignupRequestDto {
    private String email;
    private String username;
    private String password;
    public MemberSignupRequestDto(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public Member toEntity(){
        return Member.builder()
                .email(this.email)
                .username(this.username)
                .password(this.password)
                .build();
    }

}
