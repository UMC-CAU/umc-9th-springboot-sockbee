package com.example.umc9th.global.security;

import com.example.umc9th.global.config.JwtProperties;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT 토큰 생성 및 검증을 담당하는 유틸리티 클래스
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final JwtProperties jwtProperties;

    /**
     * JWT 서명에 사용할 키 생성
     */
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * 액세스 토큰 생성
     *
     * @param userDetails 사용자 정보
     * @return JWT 액세스 토큰
     */
    public String createAccessToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        // CustomUserDetails인 경우 userId 추가
        if (userDetails instanceof CustomUserDetails) {
            CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
            claims.put("userId", customUserDetails.getUserId());
            claims.put("role", customUserDetails.getAuthorities().stream()
                    .findFirst()
                    .map(Object::toString)
                    .orElse("ROLE_USER"));
        }

        return createToken(claims, userDetails.getUsername(), jwtProperties.getAccessTokenExpiration());
    }

    /**
     * 리프레시 토큰 생성
     *
     * @param userDetails 사용자 정보
     * @return JWT 리프레시 토큰
     */
    public String createRefreshToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername(), jwtProperties.getRefreshTokenExpiration());
    }

    /**
     * JWT 토큰 생성
     *
     * @param claims 토큰에 포함할 정보
     * @param subject 토큰 주체 (사용자 이메일)
     * @param expiration 만료 시간
     * @return JWT 토큰
     */
    private String createToken(Map<String, Object> claims, String subject, Long expiration) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(getSigningKey())
                .compact();
    }

    /**
     * 토큰에서 사용자 이메일 추출
     *
     * @param token JWT 토큰
     * @return 사용자 이메일
     */
    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    /**
     * 토큰에서 사용자 ID 추출
     *
     * @param token JWT 토큰
     * @return 사용자 ID
     */
    public Long extractUserId(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("userId", Long.class);
    }

    /**
     * 토큰에서 모든 클레임 추출
     *
     * @param token JWT 토큰
     * @return 클레임
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * 토큰 만료 여부 확인
     *
     * @param token JWT 토큰
     * @return 만료 여부
     */
    public boolean isTokenExpired(String token) {
        try {
            Date expiration = extractAllClaims(token).getExpiration();
            return expiration.before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        }
    }

    /**
     * 토큰 유효성 검증
     *
     * @param token JWT 토큰
     * @param userDetails 사용자 정보
     * @return 유효 여부
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        try {
            String email = extractEmail(token);
            return email.equals(userDetails.getUsername()) && !isTokenExpired(token);
        } catch (JwtException | IllegalArgumentException e) {
            log.error("JWT 토큰 검증 실패: {}", e.getMessage());
            return false;
        }
    }

    /**
     * 토큰 유효성 검증 (UserDetails 없이)
     *
     * @param token JWT 토큰
     * @return 유효 여부
     */
    public boolean validateToken(String token) {
        try {
            extractAllClaims(token);
            return !isTokenExpired(token);
        } catch (JwtException | IllegalArgumentException e) {
            log.error("JWT 토큰 검증 실패: {}", e.getMessage());
            return false;
        }
    }

    public String getEmail(String token) {
        return extractEmail(token);
    }

    public boolean isValid(String token) {
        return validateToken(token);
    }
}

