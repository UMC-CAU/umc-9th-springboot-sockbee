package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.MemberReqDTO;
import com.example.umc9th.domain.member.dto.MemberResDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.enums.Role;

public class MemberConverter {

    // DTO, Salted Password, Role -> Entity
    public static Member toMember(
            MemberReqDTO.JoinDTO dto,
            String password,
            Role role
    ){
        return Member.builder()
                .name(dto.name())
                .email(dto.email())
                .password(password)
                .role(role)
                .birthDate(dto.birth())
                .address(dto.address())
                .detailAddress(dto.specAddress())
                .gender(dto.gender())
                .build();
    }

    // Entity -> Response DTO
    public static MemberResDTO.JoinDTO toJoinDTO(Member member) {
        return MemberResDTO.JoinDTO.builder()
                .memberId(member.getUserId())
                .name(member.getName())
                .email(member.getEmail())
                .createdAt(member.getCreatedAt())
                .build();
    }
}