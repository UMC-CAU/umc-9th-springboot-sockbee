package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.converter.MemberConverter;
import com.example.umc9th.domain.member.dto.MemberReqDTO;
import com.example.umc9th.domain.member.dto.MemberResDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.global.apiPayload.code.error.MemberErrorCode;
import com.example.umc9th.global.apiPayload.exception.MemberException;
import com.example.umc9th.global.security.CustomUserDetails;
import com.example.umc9th.global.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public MemberResDTO.LoginDTO login(MemberReqDTO.LoginDTO dto) {
        // 이메일로 사용자 조회
        Member member = memberRepository.findByEmail(dto.email())
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        // 비밀번호 검증
        if (!passwordEncoder.matches(dto.password(), member.getPassword())) {
            throw new MemberException(MemberErrorCode.INVALID_PASSWORD);
        }

        // 계정 상태 확인
        if (member.getStatus() == com.example.umc9th.domain.member.enums.MemberStatus.BANNED) {
            throw new MemberException(MemberErrorCode.ACCOUNT_BANNED);
        }

        if (member.getStatus() == com.example.umc9th.domain.member.enums.MemberStatus.INACTIVE) {
            throw new MemberException(MemberErrorCode.ACCOUNT_INACTIVE);
        }

        // JWT 토큰 생성
        CustomUserDetails userDetails = new CustomUserDetails(member);
        String accessToken = jwtUtil.createAccessToken(userDetails);

        // 로그인 응답 DTO 생성
        return MemberConverter.toLoginDTO(member, accessToken);
    }
}

