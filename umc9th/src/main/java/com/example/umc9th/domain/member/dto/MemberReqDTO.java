package com.example.umc9th.domain.member.dto;

import com.example.umc9th.domain.member.enums.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {

    @Schema(description = "회원가입 요청 DTO")
    public record JoinDTO(
            @NotBlank
            String name,
            @Email
            String email, // 추가된 속성
            @NotBlank
            String password, // 추가된 속성
            @NotNull
            Gender gender,

            @NotNull
            @Schema(description = "생년월일", example = "1990-01-01")
            LocalDate birth,

            @NotBlank
            @Schema(description = "주소", example = "서울시 강남구")
            String address,

            @NotBlank
            @Schema(description = "상세주소", example = "101동 1001호")
            String specAddress,
            //@ExistFoods
            List<Long> preferCategory
    ){}

    @Schema(description = "로그인 요청 DTO")
    public record LoginDTO(
            @NotBlank(message = "이메일은 필수입니다.")
            @Email(message = "올바른 이메일 형식이 아닙니다.")
            @Schema(description = "회원 이메일", example = "hong@example.com")
            String email,

            @NotBlank(message = "비밀번호는 필수입니다.")
            @Schema(description = "비밀번호", example = "password123!")
            String password
    ){}
}