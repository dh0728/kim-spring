//package me.song.data_jpa.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.SecurityFilterChain;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//
//import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
//
//@RequiredArgsConstructor
//@Configuration
//public class WebSecurityConfig {
//
//    private final UserDetailsService userDetailsService;
//
//    // 스프링 시큐리티 기능 비활성
//    @Bean
//    public WebSecurityCustomizer configurer() {
//        return (web) -> web.ignoring()
//                .requestMatchers(toH2Console())
//                .requestMatchers("/static/**");
//    }
//
//    // 특정 HTTP 요청에 대한 웹 기반 보안 구성
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests()
//                .requestMatchers("/login", "/signup", "/user").permitAll() // 접근 허용 경로
//                .anyRequest().authenticated() // 그 외 요청은 인증 필요
//                .and()
//                .formLogin()
//                .loginPage("/login") // 커스텀 로그인 페이지 경로
//                .defaultSuccessUrl("/articles") // 로그인 성공 후 리다이렉트 경로
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login") // 로그아웃 성공 후 리다이렉트 경로
//                .invalidateHttpSession(true) // 세션 무효화
//                .and()
//                .csrf().disable() // CSRF 비활성화 (필요 시 활성화)
//                .build();
//    }
//}
