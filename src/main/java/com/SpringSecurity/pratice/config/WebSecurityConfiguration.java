package com.SpringSecurity.pratice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().and()
                .csrf()
                .and()
                .cors().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/**").permitAll().anyRequest().authenticated();
    }
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/**api-docs","/swagger-resources/**","/swagger-ui.html","/webjars/**","/swagger/**","/configuration/ui","/api/**","/h2-console/**");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder(12);
    }
}

//antMatchers() : "특정 리소스에 대해서 권한을 설정합니다."
//permitAll() : "antMatchedrs 설정한 리소스의 접근을 인증저라 없이 허용한다는 의미."
//hasAnyRole() : "antMatchers의 매개변수 값으로 시작하는 모든 URL은 인증 후 hasAnyRole의 매개변수 레벨의 권한을 가진 사용자만 접근을 허용한다는 의미
// ex) antMatchers("/admin/**").hasAnyRole("ADMIN")
// anyRequest() : "모든 리소스를 의미하며 접근 허용 리소스 및 인증 후 특정 레벨의 권한을 가진 사용자만 접근가능한 리소스를 설정하고 그 외 나머지 리소슫르은 무조건 인증을 완료해야 접근이 가능하다는 의미입니다.
// anyRequest().authenticated() <<<<<<-