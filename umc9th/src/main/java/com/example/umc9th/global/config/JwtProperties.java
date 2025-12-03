package com.example.umc9th.global.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWT 관련 설정을 application.yml에서 읽어오는 클래스
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    /**
     * JWT 서명에 사용할 비밀키
     */
    private String secret;

    /**
     * 액세스 토큰 만료 시간 (밀리초)
     * 기본값: 1시간 (3600000ms)
     */
    private Long accessTokenExpiration = 3600000L;

    /**
     * 리프레시 토큰 만료 시간 (밀리초)
     * 기본값: 7일 (604800000ms)
     */
    private Long refreshTokenExpiration = 604800000L;
}

