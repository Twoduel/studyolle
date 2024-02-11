package com.example.studyolle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.sql.DataSource;

//Spring Security에서 접근 제한하는 요소 접근 가능하도록
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain fileterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception{
        MvcRequestMatcher.Builder mvcMaatcherBuilder = new MvcRequestMatcher.Builder(introspector);
        http.authorizeHttpRequests((requests)->requests
                .requestMatchers(
                        mvcMaatcherBuilder.pattern("/"), mvcMaatcherBuilder.pattern("/login"), mvcMaatcherBuilder.pattern("/sign-up")
                        ,mvcMaatcherBuilder.pattern("/check-email") ,mvcMaatcherBuilder.pattern("/check-email-token"),
                        mvcMaatcherBuilder.pattern("/check-email-login"), mvcMaatcherBuilder.pattern("/email-login"), mvcMaatcherBuilder.pattern("/profile/*")

                ).permitAll()
                .requestMatchers(mvcMaatcherBuilder.pattern(HttpMethod.POST, "/profile/*")).permitAll()
                .anyRequest().authenticated()
        );

        return http.build();
    }
}
