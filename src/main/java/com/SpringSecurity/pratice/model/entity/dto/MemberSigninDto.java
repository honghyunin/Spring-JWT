package com.SpringSecurity.pratice.model.entity.dto;

import com.SpringSecurity.pratice.model.entity.Member;
import com.SpringSecurity.pratice.model.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;

@Builder
@Getter @Setter
@NoArgsConstructor
public class MemberSigninDto {
    private String email;
    private String password;

    //update
    public MemberSigninDto(String email,String password){
        this.email = email;
        this.password = password;
    }

    public Member toEntity(){
        return Member.builder()
                .email(this.getEmail())
                .password(this.getPassword())
                .roles(Collections.singletonList(Role.ROLE_USER))
                .build();
    }

}
