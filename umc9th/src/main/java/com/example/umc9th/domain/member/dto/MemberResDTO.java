package com.example.umc9th.domain.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberResDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "회원가입 응답 DTO")
    public static class JoinDTO {
        @Schema(description = "회원 ID", example = "1")
        private Long memberId;

        @Schema(description = "회원 이름", example = "홍길동")
        private String name;

        @Schema(description = "회원 이메일", example = "hong@example.com")
        private String email;

        @Schema(description = "가입 일시")
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "로그인 응답 DTO")
    public static class LoginDTO {
        @Schema(description = "회원 ID", example = "1")
        private Long memberId;

        @Schema(description = "회원 이름", example = "홍길동")
        private String name;

        @Schema(description = "회원 이메일", example = "hong@example.com")
        private String email;

        @Schema(description = "회원 권한", example = "ROLE_USER")
        private String role;

        @Schema(description = "JWT 액세스 토큰 (향후 구현)", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
        private String accessToken;

        @Schema(description = "JWT 리프레시 토큰 (향후 구현)", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
        private String refreshToken;
    }
}
