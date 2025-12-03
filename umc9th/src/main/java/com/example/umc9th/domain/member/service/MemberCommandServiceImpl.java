package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.converter.MemberConverter;
import com.example.umc9th.domain.member.dto.MemberReqDTO;
import com.example.umc9th.domain.member.dto.MemberResDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.enums.Role;
import com.example.umc9th.domain.member.mapping.UserFoodTag;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.member.repository.UserFoodTagRepository;
import com.example.umc9th.domain.store.entity.FoodTag;
import com.example.umc9th.domain.store.repository.FoodTagRepository;
import com.example.umc9th.global.apiPayload.code.error.MemberErrorCode;
import com.example.umc9th.global.apiPayload.exception.MemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberCommandServiceImpl implements MemberCommandService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final FoodTagRepository foodTagRepository;
    private final UserFoodTagRepository userFoodTagRepository;

    // 회원가입
    @Override
    public MemberResDTO.JoinDTO signup(MemberReqDTO.JoinDTO dto) {

        // 이메일 중복 체크
        if (memberRepository.existsByEmail(dto.email())) {
            throw new MemberException(MemberErrorCode.EMAIL_ALREADY_EXISTS);
        }

        // 솔트된 비밀번호 생성
        String encodedPassword = passwordEncoder.encode(dto.password());

        // 사용자 생성: 유저 / 관리자는 따로 API 만들어서 관리
        Member member = MemberConverter.toMember(dto, encodedPassword, Role.ROLE_USER);

        // 회원 저장
        Member savedMember = memberRepository.save(member);

        // 선호 음식 카테고리 저장
        if (dto.preferCategory() != null && !dto.preferCategory().isEmpty()) {
            List<FoodTag> foodTags = foodTagRepository.findAllById(dto.preferCategory());

            List<UserFoodTag> userFoodTags = foodTags.stream()
                    .map(foodTag -> UserFoodTag.builder()
                            .member(savedMember)
                            .tag(foodTag)
                            .build())
                    .collect(Collectors.toList());

            userFoodTagRepository.saveAll(userFoodTags);
        }

        return MemberConverter.toJoinDTO(savedMember);
    }
}
