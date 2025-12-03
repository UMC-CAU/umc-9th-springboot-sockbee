package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.dto.MemberReqDTO;
import com.example.umc9th.domain.member.dto.MemberResDTO;
import com.example.umc9th.domain.member.service.MemberCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Tag(name = "회원 관리", description = "회원 관련 API")
public class MemberController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/sign-up")
    @Operation(
            summary = "회원가입",
            description = "새로운 회원을 등록합니다. 이메일은 중복될 수 없습니다."
    )
    public ApiResponse<MemberResDTO.JoinDTO> signUp(
            @Parameter(description = "회원가입 요청 정보", required = true)
            @Valid @RequestBody MemberReqDTO.JoinDTO request
    ) {
        MemberResDTO.JoinDTO response = memberCommandService.signup(request);
        return ApiResponse.onSuccess(
                com.example.umc9th.global.apiPayload.code.success.GeneralSuccessCode.CREATED,
                response
        );
    }

    @PostMapping("/login")
    @Operation(
            summary = "로그인",
            description = "이메일과 비밀번호로 로그인합니다. 성공 시 JWT 토큰을 반환합니다. (현재는 임시 토큰)"
    )
    public ApiResponse<MemberResDTO.LoginDTO> login(
            @Parameter(description = "로그인 요청 정보", required = true)
            @Valid @RequestBody MemberReqDTO.LoginDTO request
    ) {
        MemberResDTO.LoginDTO response = memberCommandService.login(request);
        return ApiResponse.onSuccess(
                com.example.umc9th.global.apiPayload.code.success.GeneralSuccessCode.OK,
                response
        );
    }
}

